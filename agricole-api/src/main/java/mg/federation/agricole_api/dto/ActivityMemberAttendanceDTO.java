package mg.federation.agricole_api.dto;
import mg.federation.agricole_api.entity.enumeration.Enumerations.AttendanceStatus;

public record ActivityMemberAttendanceDTO(
    String id,
    MemberDescriptionDTO memberDescription,
    AttendanceStatus attendanceStatus
) {}