package InQ.projectmanager.service.relationService;

import InQ.projectmanager.domain.member.Member;
import InQ.projectmanager.domain.project.Project;
import InQ.projectmanager.repository.relationRepository.RelationRepository;
import InQ.projectmanager.service.memberService.MemberService;
import InQ.projectmanager.service.projectService.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RelationServiceImpl implements RelationService {

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
                .filter(relation -> relation.getMemberId().equals(memberId))
                .map(relation -> relation.getProjectId())
                .map(id -> projectService.findById(id))
                .collect(Collectors.toList());
    }

    @Override
    public List<Member> findJoinedMembers(Long projectId) {
        return relationRepository.findAll().stream()
                .filter(relation -> relation.getProjectId().equals(projectId))
                .map(relation -> relation.getMemberId())
                .map(id -> memberService.findById(id))
                .collect(Collectors.toList());
    }
}



//    private final relationRepository joinProjectRepository;
//
//    //프로젝트 참가
//    public JoinProject joinProject(Member member, Project project) {
//        State projectState = project.getState();
//        if (projectState.equals(State.valueOf("RECRUIT"))) {
//            return joinProjectRepository.join(member, project);
//        }
//        return null;
//    }
//
//    //사용자 기준 조회
//    public ArrayList<Long> findJoinProjectByMemberId(Member member) {return joinProjectRepository.findByMemberId(member);}
//
//    //프로젝트 기준 조회
//    public ArrayList<Long> findJoinProjectByProjectId(Project project) {return joinProjectRepository.findByProjectId(project);}
