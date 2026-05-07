package mg.federation.agricole_api.service;

import lombok.RequiredArgsConstructor;
import mg.federation.agricole_api.dto.CollectivityInformation;
import mg.federation.agricole_api.dto.CollectivityLocalStatisticsDTO;
import mg.federation.agricole_api.dto.CollectivityOverallStatisticsDTO;
import mg.federation.agricole_api.dto.MemberDescription;
import mg.federation.agricole_api.entity.Collectivity;
import mg.federation.agricole_api.entity.Member;
import mg.federation.agricole_api.entity.MemberPayment;
import mg.federation.agricole_api.entity.MembershipFee;
import mg.federation.agricole_api.entity.enumeration.Enumerations.ActivityStatus;
import mg.federation.agricole_api.repository.CollectivityRepository;
import mg.federation.agricole_api.repository.MemberPaymentRepository;
import mg.federation.agricole_api.repository.MemberRepository;
import mg.federation.agricole_api.repository.MembershipFeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    private final MemberRepository memberRepository;
    private final CollectivityRepository collectivityRepository;
    private final MemberPaymentRepository paymentRepository;
    private final MembershipFeeRepository feeRepository;
    private final ActivityService activityService;
S
    private double calculateExpected(
            String collectivityId,
            LocalDate from,
            LocalDate to
    ) {

        List<MembershipFee> fees =
                feeRepository.findByCollectivityIdAndStatus(
                        collectivityId,
                        ActivityStatus.ACTIVE
                );

        double total = 0;

        for (MembershipFee fee : fees) {

            switch (fee.getFrequency()) {

                case WEEKLY ->
                        total += ChronoUnit.WEEKS.between(from, to)
                                * fee.getAmount();

                case MONTHLY ->
                        total += ChronoUnit.MONTHS.between(from, to)
                                * fee.getAmount();

                case ANNUALLY ->
                        total += ChronoUnit.YEARS.between(from, to)
                                * fee.getAmount();

                case PUNCTUALLY ->
                        total += fee.getAmount();
            }
        }

        return total;
    }

    

    public List<CollectivityLocalStatisticsDTO> getLocalStats(
            String collectivityId,
            LocalDate from,
            LocalDate to
    ) {

        List<Member> members =
                memberRepository.findByCollectivityId(collectivityId);

        return members.stream().map(member -> {

            double paid = paymentRepository
                    .findByMemberIdAndCreationDateBetween(
                            member.getId(),
                            from,
                            to
                    )
                    .stream()
                    .mapToDouble(MemberPayment::getAmount)
                    .sum();

            double expected =
                    calculateExpected(
                            collectivityId,
                            from,
                            to
                    );

            CollectivityLocalStatisticsDTO dto =
                    new CollectivityLocalStatisticsDTO();

            dto.setMemberDescription(
                    mapToDescription(member)
            );

            dto.setEarnedAmount(paid);

            dto.setUnpaidAmount(
                    Math.max(0, expected - paid)
            );

            dto.setAttendanceRate(
                    activityService.calculateAttendanceRate(
                            member.getId(),
                            collectivityId
                    )
            );

            return dto;

        }).toList();
    }

    public List<CollectivityOverallStatisticsDTO> getGlobalStats(
            LocalDate from,
            LocalDate to
    ) {

        return collectivityRepository.findAll()
                .stream()
                .map(collectivity -> {

                    List<Member> members =
                            memberRepository.findByCollectivityId(
                                    collectivity.getId()
                            );

                    long upToDateMembers =
                            members.stream()
                                    .filter(member ->
                                            isUpToDate(
                                                    member,
                                                    collectivity.getId(),
                                                    from,
                                                    to
                                            )
                                    )
                                    .count();

                    int newMembers =
                            (int) members.stream()
                                    .filter(member ->
                                            member.getCreationDate() != null
                                                    && !member.getCreationDate().isBefore(from)
                                                    && !member.getCreationDate().isAfter(to)
                                    )
                                    .count();

                    CollectivityOverallStatisticsDTO dto =
                            new CollectivityOverallStatisticsDTO();

                    dto.setCollectivityInformation(
                            mapToInfo(collectivity)
                    );

                    dto.setNewMembersNumber(newMembers);

                    dto.setOverallMemberCurrentDuePercentage(
                            members.isEmpty()
                                    ? 0
                                    : (upToDateMembers * 100.0 / members.size())
                    );

                    dto.setGlobalAttendanceRate(
                            activityService.calculateGlobalAttendanceRate(
                                    collectivity.getId()
                            )
                    );

                    return dto;

                }).toList();
    }

    private boolean isUpToDate(
            Member member,
            String collectivityId,
            LocalDate from,
            LocalDate to
    ) {

        double paid = paymentRepository
                .findByMemberIdAndCreationDateBetween(
                        member.getId(),
                        from,
                        to
                )
                .stream()
                .mapToDouble(MemberPayment::getAmount)
                .sum();

        double expected =
                calculateExpected(
                        collectivityId,
                        from,
                        to
                );

        return paid >= expected;
    }

    private MemberDescription mapToDescription(Member member) {

        return MemberDescription.builder()
                .id(member.getId())
                .firstName(member.getFirstName())
                .lastName(member.getLastName())
                .email(member.getEmail())
                .occupation(
                        member.getOccupation() != null
                                ? member.getOccupation().name()
                                : null
                )
                .build();
    }

    private CollectivityInformation mapToInfo(
            Collectivity collectivity
    ) {

        return CollectivityInformation.builder()
                .name(collectivity.getName())
                .number(collectivity.getNumber())
                .build();
    }
}