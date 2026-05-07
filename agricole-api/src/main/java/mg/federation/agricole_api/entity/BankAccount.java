package mg.federation.agricole_api.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;
import mg.federation.agricole_api.entity.enumeration.Enumerations.Bank;

@Entity
@DiscriminatorValue("BANK")
@Data
@EqualsAndHashCode(callSuper = true)
public class BankAccount extends FinancialAccount {
    private String holderName;
    @Enumerated(EnumType.STRING)
    private Bank bankName;
    private String bankCode;
    private String bankBranchCode;
    private String bankAccountNumber;
    private String bankAccountKey;
}