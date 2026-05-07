package mg.federation.agricole_api.repository;

import mg.federation.agricole_api.entity.Member;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {
    List<Member> findByCollectivityId(String collectivityId);
    int countByCollectivityIdAndCreatedAtBetween(String collectivityId, LocalDate from, LocalDate to);
}
