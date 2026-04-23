package mg.federation.agricole_api.repository;

import mg.federation.agricole_api.entity.Collectivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectivityRepository extends JpaRepository<Collectivity, String> {
    boolean existsByName(String name);
    boolean existsByNumber(Integer number); // Changé en Integer
    
    
    boolean existsByIdAndMembersId(String collectivityId, String memberId);
}