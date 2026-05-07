package mg.federation.agricole_api.service;

import lombok.RequiredArgsConstructor;
import mg.federation.agricole_api.dto.CollectivityLocalStatisticsDTO;
import mg.federation.agricole_api.dto.CollectivityOverallStatisticsDTO;
import mg.federation.agricole_api.dto.MemberFinancialStatusDTO;
import mg.federation.agricole_api.entity.Collectivity;
import mg.federation.agricole_api.entity.Member;
import mg.federation.agricole_api.entity.MembershipFee;
import mg.federation.agricole_api.entity.enumeration.Enumerations.ActivityStatus;
import mg.federation.agricole_api.repository.*;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final CollectivityRepository collectivityRepository;
    private final MemberRepository memberRepository;
    private final MembershipFeeRepository membershipFeeRepository;
    private final MemberPaymentRepository memberPaymentRepository;

    public List<CollectivityOverallStatisticsDTO> getOverallStatistics(LocalDate from, LocalDate to) {
        return collectivityRepository.findAll().stream().map(col -> {
            
            
            int newMembers = memberRepository.countByCollectivityIdAndCreatedAtBetween(col.getId(), from, to);
            
            
            List<Member> members = memberRepository.findByCollectivityId(col.getId());
            
            
            List<MembershipFee> activeFees = membershipFeeRepository.findByCollectivityIdAndStatus(col.getId(), ActivityStatus.ACTIVE);

            long upToDateCount = 0;
            if (!members.isEmpty()) {
                upToDateCount = members.stream()
                    .filter(m -> isMemberUpToDate(m, activeFees, from, to))
                    .count();
            }

            double percentage = members.isEmpty() ? 100.0 : (double) upToDateCount / members.size() * 100.0;

            return new CollectivityOverallStatisticsDTO(
                col.getName(),
                col.getNumber(),
                newMembers,
                Math.round(percentage * 100.0) / 100.0
            );
        }).collect(Collectors.toList());
    }

    private boolean isMemberUpToDate(Member member, List<MembershipFee> activeFees, LocalDate from, LocalDate to) {
        if (activeFees.isEmpty()) return true;
        for (MembershipFee fee : activeFees) {
            boolean paid = memberPaymentRepository.existsByMemberIdAndMembershipFeeIdAndPaymentDateBetween(
                member.getId(), fee.getId(), from, to);
            if (!paid) return false;
        }
        return true;
    }
    

    public CollectivityLocalStatisticsDTO getLocalStatistics(String collectivityId, LocalDate from, LocalDate to) {
    Collectivity col = collectivityRepository.findById(collectivityId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    List<Member> members = memberRepository.findByCollectivityId(collectivityId);
    
    
    List<MembershipFee> activeFees = membershipFeeRepository.findByCollectivityIdAndStatus(collectivityId, ActivityStatus.ACTIVE);

    List<MemberFinancialStatusDTO> memberStats = members.stream().map(member -> {
        
        double totalPaid = calculateTotalPaid(member.getId(), from, to);

        
        double potentialUnpaid = calculatePotentialUnpaid(member.getId(), activeFees, from, to);

        String fullName = member.getFirstName() + " " + member.getLastName();
        return new MemberFinancialStatusDTO(fullName, totalPaid, potentialUnpaid);
    }).collect(Collectors.toList());

    return new CollectivityLocalStatisticsDTO(col.getName(), memberStats);
}

private double calculateTotalPaid(String memberId, LocalDate from, LocalDate to) {
    
    return memberPaymentRepository.findAllByMemberIdAndPaymentDateBetween(memberId, from, to)
            .stream()
            .mapToDouble(payment -> payment.getAmount()) 
            .sum();
}

private double calculatePotentialUnpaid(String memberId, List<MembershipFee> activeFees, LocalDate from, LocalDate to) {
    double unpaid = 0.0;
    for (MembershipFee fee : activeFees) {
        boolean isPaid = memberPaymentRepository.existsByMemberIdAndMembershipFeeIdAndPaymentDateBetween(
                memberId, fee.getId(), from, to);
        
        if (!isPaid) {
            unpaid += fee.getAmount(); // On ajoute le montant de la cotisation active non payée
        }
    }
    return unpaid;
}
}