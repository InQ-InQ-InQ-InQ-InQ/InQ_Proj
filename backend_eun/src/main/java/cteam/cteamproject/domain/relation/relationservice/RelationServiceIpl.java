package cteam.cteamproject.domain.relation.relationservice;

import cteam.cteamproject.domain.member.Member;
import cteam.cteamproject.domain.member.memberservice.MemberService;
import cteam.cteamproject.domain.relation.Relation;
import cteam.cteamproject.domain.relation.relationrepository.RelationRepository;
import cteam.cteamproject.domain.project.Project;
import cteam.cteamproject.domain.project.projectservice.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RelationServiceIpl implements RelationService{

    private final RelationRepository relationRepository;
    private final ProjectService projectService;
    private final MemberService memberService;

    @Override
    public void addRelation(Long memberId, Long projectId) {
        relationRepository.addRelation(memberId, projectId);
    }

    @Override
    public void removeRelation(Long memberId, Long projectId) {
        relationRepository.removeRelation(memberId, projectId);
    }

    @Override
    public List<Project> findJoiningProjects(Long memberId) {
        return relationRepository.findAll().stream()
                .filter(r -> r.getMemberId().equals(memberId))
                .map(Relation::getProjectId)
                .map(projectService::findById)
                .collect(Collectors.toList());
    }

    @Override
    public List<Member> findJoinedMembers(Long projectId) {
        return relationRepository.findAll().stream()
                .filter(r -> r.getProjectId().equals(projectId))
                .map(Relation::getMemberId)
                .map(memberService::findById)
                .collect(Collectors.toList());
    }
}
