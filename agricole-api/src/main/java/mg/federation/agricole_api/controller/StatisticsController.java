package mg.federation.agricole_api.controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.time.LocalDate;
import java.util.List;
import mg.federation.agricole_api.service.StatisticsService;
import mg.federation.agricole_api.dto.CollectivityLocalStatisticsDTO;
import mg.federation.agricole_api.dto.CollectivityOverallStatisticsDTO;

@RestController
@RequestMapping("/collectivities")
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService service;

    @GetMapping("/{id}/statistics")
    public List<CollectivityLocalStatisticsDTO> getLocal(
            @PathVariable String id,
            @RequestParam LocalDate from,
            @RequestParam LocalDate to
    ) {
        return service.getLocalStats(id, from, to);
    }

    @GetMapping("/statistics")
    public List<CollectivityOverallStatisticsDTO> getGlobal(
            @RequestParam LocalDate from,
            @RequestParam LocalDate to
    ) {
        return service.getGlobalStats(from, to);
    }
}