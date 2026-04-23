package mg.federation.agricole_api.dto;

import lombok.Data;
import java.time.LocalDate;
import mg.federation.agricole_api.entity.enumeration.Enumerations.Frequency;

@Data
public class CreateMembershipFeeDTO {
    private LocalDate eligibleFrom;
    private Frequency frequency;
    private Double amount;
    private String label;
}