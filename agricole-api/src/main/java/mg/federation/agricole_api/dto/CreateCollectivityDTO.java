package mg.federation.agricole_api.dto;

import lombok.Data;
import java.util.List;

@Data
public class CreateCollectivityDTO {
    private String location;
    private List<String> members;
    private Boolean federationApproval;
    private CreateCollectivityStructureDTO structure;
}