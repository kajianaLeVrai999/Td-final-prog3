package mg.federation.agricole_api.dto;

import lombok.Data;
import mg.federation.agricole_api.entity.enumeration.Enumerations.PaymentMode;

@Data
public class CreateMemberPaymentDTO {
    private Double amount;
    private String membershipFeeIdentifier;
    private String accountCreditedIdentifier;
    private PaymentMode paymentMode;
}