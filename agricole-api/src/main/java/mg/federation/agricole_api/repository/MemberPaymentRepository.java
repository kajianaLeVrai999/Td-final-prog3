package mg.federation.agricole_api.repository;

import mg.federation.agricole_api.entity.MemberPayment;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberPaymentRepository extends JpaRepository<MemberPayment, String> {
    
    List<MemberPayment> findByMemberIdAndCreationDateBetween(
            String memberId,
            LocalDate from,
            LocalDate to
    );
}