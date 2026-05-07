package mg.federation.agricole_api.service;

import lombok.RequiredArgsConstructor;
import mg.federation.agricole_api.dto.*;
import mg.federation.agricole_api.entity.*;
import mg.federation.agricole_api.entity.enumeration.Enumerations.AttendanceStatus;
import mg.federation.agricole_api.entity.enumeration.Enumerations.ActivityType;
import mg.federation.agricole_api.entity.enumeration.Enumerations.MemberOccupation;
import mg.federation.agricole_api.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final AttendanceRepository attendanceRepository;
    private final CollectivityRepository collectivityRepository;
    private final MemberRepository memberRepository;

    
    @Transactional
    public List<Activity> createActivities(String collectivityId, List<CreateCollectivityActivityDTO> dtos) {
        Collectivity collectivity = collectivityRepository.findById(collectivityId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Collectivity not found"));

        return dtos.stream().map(dto -> {
            Activity activity = new Activity();
            activity.setId(UUID.randomUUID().toString());
            activity.setLabel(dto.label());
            activity.setActivityType(ActivityType.valueOf(dto.activityType().toUpperCase()));
            
            activity.setMemberOccupationConcerned(dto.memberOccupationConcerned().stream()
                    .map(occ -> MemberOccupation.valueOf(occ.toUpperCase()))
                    .collect(Collectors.toList()));

            activity.setExecutiveDate(dto.executiveDate());
            if (dto.recurrenceRule() != null) {
                activity.setWeekOrdinal(dto.recurrenceRule().weekOrdinal());
                activity.setDayOfWeek(dto.recurrenceRule().dayOfWeek());
            }
            activity.setCollectivity(collectivity);
            return activityRepository.save(activity);
        }).collect(Collectors.toList());
    }

    
    public List<ActivityMemberAttendanceDTO> getFullAttendanceList(String activityId) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found"));

        List<Attendance> savedAttendances = attendanceRepository.findByActivityId(activityId);
        Map<String, Attendance> attendanceMap = savedAttendances.stream()
                .collect(Collectors.toMap(Attendance::getMemberId, a -> a));

        List<Member> members = memberRepository.findByCollectivityId(activity.getCollectivity().getId());
        List<ActivityMemberAttendanceDTO> result = new ArrayList<>();

        for (Member member : members) {
            if (attendanceMap.containsKey(member.getId())) {
                result.add(convertToAttendanceDTO(attendanceMap.get(member.getId())));
            } else if (activity.getMemberOccupationConcerned().contains(member.getOccupation())) {
                // Par défaut, si concerné mais pas pointé : UNDEFINED
                result.add(new ActivityMemberAttendanceDTO(
                    null,
                    convertToDescriptionDTO(member),
                    AttendanceStatus.UNDEFINED
                ));
            }
        }
        return result;
    }

    
    @Transactional
    public List<ActivityMemberAttendanceDTO> confirmAttendance(String activityId, List<CreateActivityMemberAttendanceDTO> dtos) {
        return dtos.stream().map(dto -> {
            Attendance attendance = attendanceRepository.findByActivityIdAndMemberId(activityId, dto.memberIdentifier())
                    .orElseGet(() -> {
                        Attendance newAtt = new Attendance();
                        newAtt.setId(UUID.randomUUID().toString());
                        newAtt.setActivityId(activityId);
                        newAtt.setMemberId(dto.memberIdentifier());
                        newAtt.setStatus(AttendanceStatus.UNDEFINED);
                        return newAtt;
                    });

            // Bonus 1 : Verrouillage si déjà pointé
            if (attendance.getStatus() != AttendanceStatus.UNDEFINED) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Status already set");
            }

            attendance.setStatus(AttendanceStatus.valueOf(dto.attendanceStatus().toUpperCase()));
            return convertToAttendanceDTO(attendanceRepository.save(attendance));
        }).collect(Collectors.toList());
    }

    private ActivityMemberAttendanceDTO convertToAttendanceDTO(Attendance attendance) {
        Member m = memberRepository.findById(attendance.getMemberId()).orElse(null);
        return new ActivityMemberAttendanceDTO(
                attendance.getId(),
                convertToDescriptionDTO(m),
                attendance.getStatus()
        );
    }

    private MemberDescriptionDTO convertToDescriptionDTO(Member m) {
        if (m == null) return null;
        return new MemberDescriptionDTO(
                m.getId(), m.getFirstName(), m.getLastName(), m.getEmail(), m.getOccupation().name()
        );
    }
}