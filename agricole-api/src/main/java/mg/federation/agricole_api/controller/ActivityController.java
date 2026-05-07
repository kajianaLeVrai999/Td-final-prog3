package mg.federation.agricole_api.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import java.util.List;
import mg.federation.agricole_api.dto.*;
import mg.federation.agricole_api.service.ActivityService;

@RestController
@RequestMapping("/collectivities")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityService service;

    @PostMapping("/{id}/activities")
    public ResponseEntity<List<Activity>> createActivities(
            @PathVariable String id, 
            @RequestBody List<CreateCollectivityActivityDTO> dtos) {
        
        // Validation OAS : Pas de date ET de récurrence en même temps 
        for (CreateCollectivityActivityDTO dto : dtos) {
            if (dto.executiveDate() != null && dto.recurrenceRule() != null) {
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.ok(service.createActivities(id, dtos));
    }

    @GetMapping("/{id}/activities")
    public List<Activity> getActivities(@PathVariable String id) {
        return service.getActivities(id);
    }

    @PostMapping("/{id}/activities/{activityId}/attendance")
    @ResponseStatus(HttpStatus.CREATED)
    public List<ActivityMemberAttendanceDTO> confirmAttendance(
            @PathVariable String id,
            @PathVariable String activityId, 
            @RequestBody List<CreateActivityMemberAttendanceDTO> attendances) {
        
        
        return service.confirmAttendance(activityId, attendances);
    }

    @GetMapping("/{id}/activities/{activityId}/attendance")
    public List<ActivityMemberAttendanceDTO> getAttendance(
            @PathVariable String id,
            @PathVariable String activityId) {
        
        return service.getFullAttendanceList(activityId);
    }
}