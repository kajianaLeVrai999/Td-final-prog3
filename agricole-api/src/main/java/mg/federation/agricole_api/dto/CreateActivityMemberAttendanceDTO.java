package mg.federation.agricole_api.dto;

public record CreateActivityMemberAttendanceDTO(
    String memberIdentifier,
    String attendanceStatus
) {}
