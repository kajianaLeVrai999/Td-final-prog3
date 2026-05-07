package mg.federation.agricole_api.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import mg.federation.agricole_api.entity.enumeration.Enumerations.AttendanceStatus;

public record ActivityMemberAttendanceDTO(
    String id,
    MemberDescriptionDTO memberDescription,
    @Enumerated(EnumType.STRING)
    AttendanceStatus attendanceStatus
) {}
