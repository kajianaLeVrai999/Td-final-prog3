package mg.federation.agricole_api.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("CASH")
public class CashAccount extends FinancialAccount {
    
}