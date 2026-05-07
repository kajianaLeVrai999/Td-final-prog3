package mg.federation.agricole_api.controller;

import lombok.RequiredArgsConstructor;
import mg.federation.agricole_api.dto.CollectivityOverallStatisticsDTO;
import mg.federation.agricole_api.service.StatisticsService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping("/collectivites/statistics") 
    public List<CollectivityOverallStatisticsDTO> getGlobalStats(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        return statisticsService.getOverallStatistics(from, to);
    }
}