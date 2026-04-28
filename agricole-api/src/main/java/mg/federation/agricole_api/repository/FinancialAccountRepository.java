package mg.federation.agricole_api.repository;

import mg.federation.agricole_api.entity.FinancialAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FinancialAccountRepository extends JpaRepository<FinancialAccount, String> {
    List<FinancialAccount> findByCollectivity_Id(String collectivityId);
}