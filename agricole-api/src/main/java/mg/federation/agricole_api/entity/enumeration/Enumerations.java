package mg.federation.agricole_api.entity.enumeration;

public class Enumerations {
    public enum PaymentMode { CASH, MOBILE_BANKING, BANK_TRANSFER }
    public enum Frequency { WEEKLY, MONTHLY, ANNUALLY, PUNCTUALLY }
    public enum ActivityStatus { ACTIVE, INACTIVE }
    public enum MobileBankingService { AIRTEL_MONEY, MVOLA, ORANGE_MONEY }
    public enum Bank { BRED, MCB, BMOI, BOA, BGFI, AFG, ACCES_BAQUE, BAOBAB, SIPEM }
    public enum Gender { MALE, FEMALE }
    public enum MemberOccupation { JUNIOR, SENIOR, SECRETARY, TREASURER, VICE_PRESIDENT, PRESIDENT }
}
