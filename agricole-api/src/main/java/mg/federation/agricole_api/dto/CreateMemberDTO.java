package mg.federation.agricole_api.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;
import mg.federation.agricole_api.entity.enumeration.Enumerations.Gender;
import mg.federation.agricole_api.entity.enumeration.Enumerations.MemberOccupation;

@Data
public class CreateMemberDTO {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Gender gender;
    private String address;
    private String profession;
    private String phoneNumber;
    private String email;
    private MemberOccupation occupation;
    private String collectivityIdentifier;
    private List<String> referees;
    private Boolean registrationFeePaid;
    private Boolean membershipDuesPaid;
}
