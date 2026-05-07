package mg.federation.agricole_api.dto;

public record MonthlyRecurrenceRuleDTO(
    Integer weekOrdinal, 
    String dayOfWeek     
) {}
