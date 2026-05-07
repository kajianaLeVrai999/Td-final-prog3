package mg.federation.agricole_api.dto;

import lombok.Data;

@Data
public class CollectivityOverallStatisticsDTO {

    private CollectivityInformation collectivityInformation;
    private int newMembersNumber;
    private double overallMemberCurrentDuePercentage;

    private double globalAttendanceRate;
}