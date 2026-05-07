package mg.federation.agricole_api.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDate;
import mg.federation.agricole_api.entity.enumeration.Enumerations.PaymentMode;

@Entity
@Data
public class CollectivityTransaction {
    @Id
    private String id;
    private LocalDate creationDate;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
    @ManyToOne
    private FinancialAccount accountCredited;
    @ManyToOne
    private Member memberDebited;
}