package mg.federation.agricole_api.service;

import lombok.RequiredArgsConstructor;
import mg.federation.agricole_api.dto.CreateCollectivityDTO;
import mg.federation.agricole_api.dto.CreateMemberDTO;
import mg.federation.agricole_api.entity.Collectivity;
import mg.federation.agricole_api.entity.CollectivityStructure;
import mg.federation.agricole_api.entity.Member;
import mg.federation.agricole_api.exception.BadRequestException;
import mg.federation.agricole_api.exception.NotFoundException;
import mg.federation.agricole_api.repository.CollectivityRepository;
import mg.federation.agricole_api.repository.MemberRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FederationService {

    private final MemberRepository memberRepo;
    private final CollectivityRepository collectivityRepo;

    public Member createMember(CreateMemberDTO dto) {

        if (!Boolean.TRUE.equals(dto.getRegistrationFeePaid())
                || !Boolean.TRUE.equals(dto.getMembershipDuesPaid())) {
            throw new BadRequestException("Paiements incomplets");
        }

        List<Member> referees = memberRepo.findAllById(dto.getReferees());

        long localReferees = referees.stream()
                .filter(r -> collectivityRepo.existsByIdAndMembersId(
                        dto.getCollectivityIdentifier(),
                        r.getId()))
                .count();

        if (localReferees < (referees.size() - localReferees)
                || referees.size() < 2) {
            throw new BadRequestException("Conditions de parrainage non remplies");
        }

        Member m = new Member();

        BeanUtils.copyProperties(dto, m);

        m.setReferees(referees);

        return memberRepo.save(m);
    }

    public Collectivity createCollectivity(CreateCollectivityDTO dto) {

        if (!Boolean.TRUE.equals(dto.getFederationApproval())) {
            throw new BadRequestException("Approbation de la fédération requise");
        }

        if (dto.getMembers() == null || dto.getMembers().size() < 10) {
            throw new BadRequestException(
                    "Une collectivité doit avoir au moins 10 membres"
            );
        }

        List<Member> members = memberRepo.findAllById(dto.getMembers());

        if (members.size() != dto.getMembers().size()) {
            throw new NotFoundException(
                    "Un ou plusieurs membres sont introuvables"
            );
        }

        CollectivityStructure struct = new CollectivityStructure();

        struct.setPresident(memberRepo.findById(
                dto.getStructure().getPresident()
        ).orElseThrow(() ->
                new NotFoundException("Président introuvable")
        ));

        struct.setVicePresident(memberRepo.findById(
                dto.getStructure().getVicePresident()
        ).orElseThrow(() ->
                new NotFoundException("Vice-Président introuvable")
        ));

        struct.setTreasurer(memberRepo.findById(
                dto.getStructure().getTreasurer()
        ).orElseThrow(() ->
                new NotFoundException("Trésorier introuvable")
        ));

        struct.setSecretary(memberRepo.findById(
                dto.getStructure().getSecretary()
        ).orElseThrow(() ->
                new NotFoundException("Secrétaire introuvable")
        ));

        Collectivity col = new Collectivity();

        col.setLocation(dto.getLocation());
        col.setMembers(members);
        col.setStructure(struct);

        return collectivityRepo.save(col);
    }

    @Transactional
    public Collectivity identifyCollectivity(
            String id,
            String name,
            String number
    ) {

        Collectivity col = collectivityRepo.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Collectivité introuvable")
                );

        if (col.getName() != null || col.getNumber() != null) {
            throw new BadRequestException(
                    "Nom et numéro déjà attribués et non modifiables"
            );
        }

        if (collectivityRepo.existsByName(name)) {
            throw new BadRequestException(
                    "Ce nom de collectivité existe déjà"
            );
        }

        if (collectivityRepo.existsByNumber(number)) {
            throw new BadRequestException(
                    "Ce numéro de collectivité existe déjà"
            );
        }

        col.setName(name);
        col.setNumber(number);

        return collectivityRepo.save(col);
    }
}