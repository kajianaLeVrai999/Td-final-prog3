package mg.federation.agricole_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

import mg.federation.agricole_api.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, String> {

    List<Attendance> findByActivityId(String activityId);
    Optional<Attendance> findByActivityIdAndMemberId(String activityId, String memberId);

    boolean existsByActivityIdAndMemberId(String activityId, String memberId);
}
