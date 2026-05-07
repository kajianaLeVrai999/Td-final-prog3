package mg.federation.agricole_api.repository;

import mg.federation.agricole_api.entity.MemberPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface MemberPaymentRepository extends JpaRepository<MemberPayment, String> {
    
    
    boolean existsByMemberIdAndMembershipFeeIdAndPaymentDateBetween(String memberId, String feeId, LocalDate start, LocalDate end);

    
    List<MemberPayment> findAllByMemberIdAndPaymentDateBetween(String memberId, LocalDate start, LocalDate end);
}