package mg.federation.agricole_api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type")
@Data
public abstract class FinancialAccount {
    @Id
    private String id;
    private Double amount;
}