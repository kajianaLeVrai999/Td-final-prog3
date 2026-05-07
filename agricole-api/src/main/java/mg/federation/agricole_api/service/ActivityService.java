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
            
            
            try {
                activity.setActivityType(ActivityType.valueOf(dto.activityType().toUpperCase()));
            } catch (Exception e) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Type d'activité invalide");
            }

            
            List<MemberOccupation> occupations = dto.memberOccupationConcerned().stream()
                    .map(occ -> MemberOccupation.valueOf(occ.toUpperCase()))
                    .collect(Collectors.toList());
            activity.setMemberOccupationConcerned(occupations);

            activity.setExecutiveDate(dto.executiveDate());
            
            if (dto.recurrenceRule() != null) {
                activity.setWeekOrdinal(dto.recurrenceRule().weekOrdinal());
                activity.setDayOfWeek(dto.recurrenceRule().dayOfWeek());
            }
            
            activity.setCollectivity(collectivity);
            return activityRepository.save(activity);
        }).collect(Collectors.toList());
    }

    @Transactional
    public List<ActivityMemberAttendanceDTO> confirmAttendance(String activityId, List<CreateActivityMemberAttendanceDTO> dtos) {
        activityRepository.findById(activityId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Activity not found"));

        return dtos.stream().map(dto -> {
            Optional<Attendance> existing = attendanceRepository.findByActivityIdAndMemberId(activityId, dto.memberIdentifier());
            
            Attendance attendance;
            if (existing.isPresent()) {
                attendance = existing.get();
                if (attendance.getStatus() != AttendanceStatus.UNDEFINED) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Status déjà confirmé");
                }
            } else {
                attendance = new Attendance();
                attendance.setId(UUID.randomUUID().toString());
                attendance.setActivityId(activityId);
                attendance.setMemberId(dto.memberIdentifier());
            }

            // CONVERSION ENUM POUR ATTENDANCE STATUS
            attendance.setStatus(AttendanceStatus.valueOf(dto.attendanceStatus().toUpperCase()));
            
            Attendance saved = attendanceRepository.save(attendance);
            return convertToAttendanceDTO(saved);
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
                result.add(new ActivityMemberAttendanceDTO(
                    null,
                    convertToDescriptionDTO(member),
                    AttendanceStatus.UNDEFINED
                ));
            }
        }
        
        for (Attendance att : savedAttendances) {
            if (members.stream().noneMatch(m -> m.getId().equals(att.getMemberId()))) {
                result.add(convertToAttendanceDTO(att));
            }
        }
        return result;
    }

    private ActivityMemberAttendanceDTO convertToAttendanceDTO(Attendance attendance) {
        Member member = memberRepository.findById(attendance.getMemberId()).orElse(null);
        return new ActivityMemberAttendanceDTO(
                attendance.getId(),
                convertToDescriptionDTO(member),
                attendance.getStatus()
        );
    }

    private MemberDescriptionDTO convertToDescriptionDTO(Member member) {
        if (member == null) return null;
        return new MemberDescriptionDTO(
                member.getId(),
                member.getFirstName(),
                member.getLastName(),
                member.getEmail(),
                member.getOccupation().name() 
        );
    }

    public double calculateGlobalAttendanceRate(String id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'calculateGlobalAttendanceRate'");
    }

    public double calculateAttendanceRate(String id, String collectivityId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateAttendanceRate'");
    }
}