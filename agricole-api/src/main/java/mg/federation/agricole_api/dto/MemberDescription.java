package mg.federation.agricole_api.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDescription {

    private String id;

    private String firstName;

    private String lastName;

    private String email;

    private String occupation;
}