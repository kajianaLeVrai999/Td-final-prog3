package mg.federation.agricole_api.dto;

public record MemberFinancialStatusDTO(
    String memberName,
    Double totalPaid,
    Double potentialUnpaid
) {}