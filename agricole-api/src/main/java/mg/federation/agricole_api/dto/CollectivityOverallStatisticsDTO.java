package mg.federation.agricole_api.dto;

public record CollectivityOverallStatisticsDTO(
    String name,
    Integer number,
    Integer newMembersNumber,
    Double overallMemberCurrentDuePercentage
) {}