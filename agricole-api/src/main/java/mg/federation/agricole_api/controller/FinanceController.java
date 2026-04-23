package mg.federation.agricole_api.controller;

import lombok.RequiredArgsConstructor;
import mg.federation.agricole_api.dto.CreateMemberPaymentDTO;
import mg.federation.agricole_api.dto.CreateMembershipFeeDTO;
import mg.federation.agricole_api.entity.*;
import mg.federation.agricole_api.service.FinancialService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FinanceController {

    private final FinancialService financialService;

    
    @GetMapping("/collectivities/{id}")
    public Collectivity getCollectivity(@PathVariable String id) {
        return financialService.getCollectivity(id);
    }

    
    @GetMapping("/collectivities/{id}/financialAccounts")
    public List<FinancialAccount> getAccounts(
            @PathVariable String id,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate at) {
        
        LocalDate dateLimit = (at != null) ? at : LocalDate.now();
        return financialService.getAccountsAtDate(id, dateLimit);
    }

    @GetMapping("/collectivities/{id}/membershipFees")
    public List<MembershipFee> getMembershipFees(@PathVariable String id) {
        return financialService.getFeesByCollectivity(id);
    }

    @PostMapping("/collectivities/{id}/membershipFees")
    public List<MembershipFee> createMembershipFees(
            @PathVariable String id,
            @RequestBody List<CreateMembershipFeeDTO> dtos) {
        return financialService.createFees(id, dtos);
    }

    @GetMapping("/collectivities/{id}/transactions")
    public List<CollectivityTransaction> getTransactions(
            @PathVariable String id,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        return financialService.findTransactions(id, from, to);
    }

    @PostMapping("/members/{id}/payments")
    @ResponseStatus(HttpStatus.CREATED)
    public List<MemberPayment> createMemberPayments(
            @PathVariable String id,
            @RequestBody List<CreateMemberPaymentDTO> dtos) {
        return dtos.stream()
                .map(dto -> financialService.processPayment(id, dto))
                .toList();
    }
}