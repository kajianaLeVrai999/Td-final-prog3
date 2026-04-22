package mg.federation.agricole_api.repository;

import mg.federation.agricole_api.entity.Collectivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectivityRepository extends JpaRepository<Collectivity, String> {
    
    
    boolean existsByIdAndMembersId(String collectivityId, String memberId);
    boolean existsByName(String name);
    boolean existsByNumber(String number);
}