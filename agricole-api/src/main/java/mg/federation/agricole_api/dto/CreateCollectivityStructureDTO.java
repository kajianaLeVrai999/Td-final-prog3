package mg.federation.agricole_api.dto;

import lombok.Data;

@Data
public class CreateCollectivityStructureDTO {
    private String president; 
    private String vicePresident; 
    private String treasurer; 
    private String secretary; 
}