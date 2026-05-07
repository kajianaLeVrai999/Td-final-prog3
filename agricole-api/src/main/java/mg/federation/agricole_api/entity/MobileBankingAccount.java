package mg.federation.agricole_api.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;
import mg.federation.agricole_api.entity.enumeration.Enumerations.MobileBankingService;

@Entity
@DiscriminatorValue("MOBILE")
@Data
@EqualsAndHashCode(callSuper = true)
public class MobileBankingAccount extends FinancialAccount {
    private String holderName;
    private String mobileNumber;

    @Enumerated(EnumType.STRING)
    private MobileBankingService mobileBankingService;
}