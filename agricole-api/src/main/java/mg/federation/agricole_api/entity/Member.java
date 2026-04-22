package mg.federation.agricole_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String address;
    private String profession;
    private Integer phoneNumber;
    private String email;
    @Enumerated(EnumType.STRING)
    private MemberOccupation occupation;
    @ManyToMany
    private List<Member> referees;
}
