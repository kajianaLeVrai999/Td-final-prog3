package mg.federation.agricole_api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import mg.federation.agricole_api.entity.enumeration.Enumerations.Gender;
import mg.federation.agricole_api.entity.enumeration.Enumerations.MemberOccupation;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Member {
    @Id 
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String address;
    private String profession;
    private String phoneNumber;
    private String email;
    private LocalDate creationDate = LocalDate.now();
    @Enumerated(EnumType.STRING)
    private MemberOccupation occupation;
    @ManyToMany
    @JoinTable(
    name = "member_referees",
    joinColumns = @JoinColumn(name = "member_id"),
    inverseJoinColumns = @JoinColumn(name = "referee_id")
    )
    private List<Member> referees;
    @ManyToOne
    @JoinColumn(name = "collectivity_id")
    private Collectivity collectivity;
}
