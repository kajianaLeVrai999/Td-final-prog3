package mg.federation.agricole_api.controller;

import lombok.RequiredArgsConstructor;
import mg.federation.agricole_api.dto.CreateMemberPaymentDTO;
import mg.federation.agricole_api.entity.MemberPayment;
import mg.federation.agricole_api.service.FinancialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberPaymentController {
    private final FinancialService financialService;

    @PostMapping("/{id}/payments")
    public ResponseEntity<List<MemberPayment>> createPayments(
            @PathVariable String id, 
            @RequestBody List<CreateMemberPaymentDTO> dtos) {
        
        List<MemberPayment> results = dtos.stream()
            .map(dto -> financialService.processPayment(id, dto))
            .toList();
            
        return new ResponseEntity<>(results, HttpStatus.CREATED);
    }
}