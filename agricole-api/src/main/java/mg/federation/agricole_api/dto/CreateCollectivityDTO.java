package mg.federation.agricole_api.dto;

import lombok.Data;
import java.util.List;

@Data
public class CreateCollectivityDTO {
    private String location;
    private List<String> members; // Liste d'IDs
    private Boolean federationApproval;
    private CreateCollectivityStructureDTO structure;
}