package mg.federation.agricole_api.repository;

import mg.federation.agricole_api.entity.MembershipFee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MembershipFeeRepository extends JpaRepository<MembershipFee, String> {
    List<MembershipFee> findByCollectivityId(String collectivityId);
}