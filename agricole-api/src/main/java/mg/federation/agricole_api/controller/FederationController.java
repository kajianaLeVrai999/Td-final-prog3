package mg.federation.agricole_api.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import mg.federation.agricole_api.dto.CreateCollectivityDTO;
import mg.federation.agricole_api.dto.CreateMemberDTO;
import mg.federation.agricole_api.entity.Collectivity;
import mg.federation.agricole_api.entity.Member;
import mg.federation.agricole_api.service.FederationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FederationController {

    private final FederationService service;

    @PostMapping("/collectivities")
    public ResponseEntity<List<Collectivity>> createCollectivities(@RequestBody List<CreateCollectivityDTO> dtos) {
        List<Collectivity> response = dtos.stream()
                .map(service::createCollectivity)
                .toList();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/members")
    public ResponseEntity<List<Member>> createMembers(@RequestBody List<CreateMemberDTO> dtos) {
        List<Member> response = dtos.stream()
                .map(service::createMember)
                .toList();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping("/collectivities/{id}/identify")
    public ResponseEntity<Collectivity> identifyCollectivity(
            @PathVariable String id, 
            @RequestBody IdentificationRequest request) {
        Collectivity updated = service.identifyCollectivity(id, request.getName(), request.getNumber());
        return ResponseEntity.ok(updated);
    }

    @Data
    public static class IdentificationRequest {
        private String name;
        private Integer number;
    }
}