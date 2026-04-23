package mg.federation.agricole_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import mg.federation.agricole_api.entity.enumeration.Enumerations.PaymentMode;

import java.time.LocalDate;

@Entity
@Data
public class MemberPayment {

    @Id
    private String id;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;

    private LocalDate creationDate;

    @ManyToOne
    @JoinColumn(name = "financial_account_id")
    private FinancialAccount accountCredited;

    // Optionnel : Si tu veux lier le paiement au membre dans la base
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}