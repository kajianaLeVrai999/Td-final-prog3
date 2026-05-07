package mg.federation.agricole_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;
import mg.federation.agricole_api.entity.enumeration.Enumerations.ActivityType;
import mg.federation.agricole_api.entity.enumeration.Enumerations.MemberOccupation;

@Entity
@Data
public class Activity {
    @Id
    private String id;
    private String label;

    @Enumerated(EnumType.STRING)
    private ActivityType activityType; // Changé de String en Enum

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<MemberOccupation> memberOccupationConcerned;

    private LocalDate executiveDate;
    private Integer weekOrdinal;
    private String dayOfWeek;

    @ManyToOne
    private Collectivity collectivity;
}