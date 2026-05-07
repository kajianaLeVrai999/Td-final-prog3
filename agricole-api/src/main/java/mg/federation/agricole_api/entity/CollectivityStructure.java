package mg.federation.agricole_api.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CollectivityStructure {
    @Id
    private Long id;

    @ManyToOne
    private Member president;

    @ManyToOne
    private Member vicePresident;

    @ManyToOne
    private Member treasurer;

    @ManyToOne
    private Member secretary;
}