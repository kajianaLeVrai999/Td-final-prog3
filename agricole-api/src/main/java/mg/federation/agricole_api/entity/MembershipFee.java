package mg.federation.agricole_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import mg.federation.agricole_api.entity.enumeration.Enumerations.ActivityStatus;
import  mg.federation.agricole_api.entity.enumeration.Enumerations.Frequency;

import java.time.LocalDate;

@Entity
@Data
public class MembershipFee {

    @Id
    private String id;


    private LocalDate eligibleFrom;

    private String label;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private Frequency frequency;

    @Enumerated(EnumType.STRING)
    private ActivityStatus status;

    @ManyToOne
    @JoinColumn(name = "collectivity_id")
    private Collectivity collectivity;
}