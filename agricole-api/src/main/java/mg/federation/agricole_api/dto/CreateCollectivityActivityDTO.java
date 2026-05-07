package mg.federation.agricole_api.dto;

import java.time.LocalDate;
import java.util.List;

public record CreateCollectivityActivityDTO(
    String label,
    String activityType,
    List<String> memberOccupationConcerned,
    MonthlyRecurrenceRuleDTO recurrenceRule,
    LocalDate executiveDate
) {}
