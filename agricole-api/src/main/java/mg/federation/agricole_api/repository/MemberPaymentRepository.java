package mg.federation.agricole_api.repository;

import mg.federation.agricole_api.entity.MemberPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberPaymentRepository extends JpaRepository<MemberPayment, String> {}