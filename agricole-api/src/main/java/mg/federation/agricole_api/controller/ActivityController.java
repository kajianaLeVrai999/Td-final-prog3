package mg.federation.agricole_api.controller;

import lombok.RequiredArgsConstructor;
import mg.federation.agricole_api.dto.ActivityMemberAttendanceDTO;
import mg.federation.agricole_api.dto.CreateActivityMemberAttendanceDTO;
import mg.federation.agricole_api.dto.CreateCollectivityActivityDTO;
import mg.federation.agricole_api.entity.Activity;
import mg.federation.agricole_api.service.ActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collectivities") 
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService activityService;

    
    @PostMapping("/{id}/activities")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Activity> createActivities(
            @PathVariable String id,
            @RequestBody List<CreateCollectivityActivityDTO> dtos) {
        return activityService.createActivities(id, dtos);
    }

    
    @GetMapping("/{id}/activities/{activityId}/attendance")
    public List<ActivityMemberAttendanceDTO> getAttendanceList(
            @PathVariable String activityId) {
        return activityService.getFullAttendanceList(activityId);
    }

    
    @PostMapping("/{id}/activities/{activityId}/attendance")
    public List<ActivityMemberAttendanceDTO> confirmAttendance(
            @PathVariable String activityId,
            @RequestBody List<CreateActivityMemberAttendanceDTO> dtos) {
        return activityService.confirmAttendance(activityId, dtos);
    }
}