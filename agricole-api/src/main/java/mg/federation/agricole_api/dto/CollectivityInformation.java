package mg.federation.agricole_api.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CollectivityInformation {

    private String name;

    private Integer number;
}