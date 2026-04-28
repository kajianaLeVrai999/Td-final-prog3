package mg.federation.agricole_api.entity.enumeration;

public class Enumerations {

    public enum PaymentMode {
        CASH,
        MOBILE_MONEY,
        BANK_TRANSFER
    }

    public enum Frequency {
        WEEKLY,
        MONTHLY,
        ANNUALLY,
        PUNCTUALLY
    }

    public enum ActivityStatus {
        ACTIVE,
        INACTIVE
    }

    public enum MobileBankingService {
        AIRTEL_MONEY,
        MVOLA,
        ORANGE_MONEY
    }

    public enum Bank {
        BRED,
        MCB,
        BMOI,
        BOA,
        BGFI,
        AFG,
        ACCES_BANQUE,
        BAOBAB,
        SIPEM
    }

    public enum Gender {
        M,
        F
    }

    public enum MemberOccupation {
        PRESIDENT,
        VICE_PRESIDENT,
        SECRETAIRE,
        TRESORIER,
        CONFIRME
    }

    public enum CollectivityOccupation {
        RIZICULTURE,
        PISCICULTURE,
        APICULTURE
    }
}