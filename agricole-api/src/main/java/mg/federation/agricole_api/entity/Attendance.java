package mg.federation.agricole_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mg.federation.agricole_api.entity.enumeration.Enumerations.AttendanceStatus;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String activityId;

    private String memberId;

    @Enumerated(EnumType.STRING)
    private AttendanceStatus status;
}