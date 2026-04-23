package mg.federation.agricole_api.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Entity @Data
public class Collectivity {
    @Id
    private String id;
    private String location;
    @OneToOne(cascade = CascadeType.ALL)
    private CollectivityStructure structure;
    @ManyToMany
    private List<Member> members;
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private Integer number;
}