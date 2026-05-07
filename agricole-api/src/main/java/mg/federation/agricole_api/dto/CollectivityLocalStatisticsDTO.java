package mg.federation.agricole_api.dto;

import lombok.Data;

@Data
public class CollectivityLocalStatisticsDTO {

    private MemberDescription memberDescription;
    private double earnedAmount;
    private double unpaidAmount;

    private double attendanceRate;
}