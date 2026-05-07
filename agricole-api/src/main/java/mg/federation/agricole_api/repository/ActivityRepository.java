package mg.federation.agricole_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import mg.federation.agricole_api.entity.Activity;

public interface ActivityRepository extends JpaRepository<Activity, String> {
    List<Activity> findByCollectivityId(String collectivityId);
}
