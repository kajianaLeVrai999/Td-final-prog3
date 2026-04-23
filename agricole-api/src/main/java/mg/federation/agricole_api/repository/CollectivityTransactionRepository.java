package mg.federation.agricole_api.repository;

import mg.federation.agricole_api.entity.CollectivityTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface CollectivityTransactionRepository extends JpaRepository<CollectivityTransaction, String> {
    List<CollectivityTransaction> findByAccountCreditedIdInAndCreationDateBetween(
        List<String> accountIds, LocalDate from, LocalDate to);
}