package mg.federation.agricole_api.service;

import lombok.RequiredArgsConstructor;
import mg.federation.agricole_api.dto.CreateMemberPaymentDTO;
import mg.federation.agricole_api.dto.CreateMembershipFeeDTO;
import mg.federation.agricole_api.entity.*;
import mg.federation.agricole_api.entity.enumeration.Enumerations.ActivityStatus;
import mg.federation.agricole_api.exception.BadRequestException;
import mg.federation.agricole_api.exception.NotFoundException;
import mg.federation.agricole_api.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FinancialService {

    private final MemberRepository memberRepo;
    private final CollectivityRepository collectivityRepo;
    private final FinancialAccountRepository accountRepo;
    private final CollectivityTransactionRepository transactionRepo;
    private final MemberPaymentRepository paymentRepo;
    private final MembershipFeeRepository feeRepo;

    @Transactional
    public MemberPayment processPayment(String memberId, CreateMemberPaymentDTO dto) {
        Member member = memberRepo.findById(memberId)
                .orElseThrow(() -> new NotFoundException("Membre introuvable"));

        FinancialAccount account = accountRepo.findById(dto.getAccountCreditedIdentifier())
                .orElseThrow(() -> new NotFoundException("Compte financier introuvable"));

        if (dto.getAmount() <= 0) throw new BadRequestException("Le montant doit être positif");

        // Historique Transaction
        CollectivityTransaction tx = new CollectivityTransaction();
        tx.setId(UUID.randomUUID().toString());
        tx.setAmount(dto.getAmount());
        tx.setPaymentMode(dto.getPaymentMode());
        tx.setAccountCredited(account);
        tx.setMemberDebited(member);
        tx.setCreationDate(LocalDate.now());
        transactionRepo.save(tx);

        // Mise à jour Solde
        account.setAmount(account.getAmount() + dto.getAmount());
        accountRepo.save(account);

        // Paiement Membre
        MemberPayment payment = new MemberPayment();
        payment.setId(UUID.randomUUID().toString());
        payment.setAmount(dto.getAmount());
        payment.setPaymentMode(dto.getPaymentMode());
        payment.setAccountCredited(account);
        payment.setCreationDate(LocalDate.now());
        payment.setMember(member);

        return paymentRepo.save(payment);
    }

    @Transactional
    public List<MembershipFee> createFees(String collectivityId, List<CreateMembershipFeeDTO> dtos) {
        Collectivity col = collectivityRepo.findById(collectivityId)
                .orElseThrow(() -> new NotFoundException("Collectivité introuvable"));

        return dtos.stream().map(dto -> {
            MembershipFee fee = new MembershipFee();
            fee.setId(UUID.randomUUID().toString());
            fee.setEligibleFrom(dto.getEligibleFrom());
            fee.setFrequency(dto.getFrequency());
            fee.setAmount(dto.getAmount());
            fee.setLabel(dto.getLabel());
            fee.setStatus(ActivityStatus.ACTIVE);
            fee.setCollectivity(col);
            return feeRepo.save(fee);
        }).toList();
    }

    public List<MembershipFee> getFeesByCollectivity(String id) {
        return feeRepo.findByCollectivityId(id);
    }

    public List<CollectivityTransaction> findTransactions(String id, LocalDate from, LocalDate to) {
        List<FinancialAccount> accounts = accountRepo.findByCollectivityId(id);
        if (accounts.isEmpty()) throw new NotFoundException("Aucun compte trouvé");

        List<String> ids = accounts.stream().map(FinancialAccount::getId).toList();
        return transactionRepo.findByAccountCreditedIdInAndCreationDateBetween(ids, from, to);
    }
}