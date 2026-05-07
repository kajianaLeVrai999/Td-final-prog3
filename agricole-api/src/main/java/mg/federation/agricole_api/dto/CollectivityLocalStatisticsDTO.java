package mg.federation.agricole_api.dto;

import java.util.List;

public record CollectivityLocalStatisticsDTO(
    String collectivityName,
    List<MemberFinancialStatusDTO> memberStats
) {}