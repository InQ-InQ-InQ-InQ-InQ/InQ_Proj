package InQ.projectmanager.repository.relationRepository;
import InQ.projectmanager.domain.relation.Relation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemoryRelationRepository implements RelationRepository {

    private static final List<Relation> relationList = new ArrayList<>();

    @Override
    public void addRelation(Long memberId, Long projectId) {
        Relation relation = new Relation(memberId, projectId);
        relationList.add(relation);
    }

    @Override
    public void removeRelation(Long memberId, Long projectId) {
        relationList.removeIf(relation -> relation.getMemberId().equals(memberId) && relation.getProjectId().equals(projectId));
    }

    @Override
    public List<Relation> findAll() {
        return relationList;
    }
}



//    private static final Map<Long, JoinProject> joinProjectList = new HashMap<>();
//    private static long sequence = 0L;
//
//    //멤버-프로젝트 조인(프로젝트 참가)
//    @Override
//    public JoinProject join(Member member, Project project) {
//        JoinProject joinProject = new JoinProject();
//        joinProject.setId(++sequence);
//        joinProject.setMemberId(member.getId());
//        joinProject.setProjectId(project.getId());
//
//        joinProjectList.put(joinProject.getId(), joinProject);
//        return joinProject;
//    }
//
//    //프로젝트 삭제
//    @Override
//    public void delete(Long id) {
//        joinProjectList.remove(id);
//    }
//
//    //프로젝트 탈퇴
//    @Override
//    public void leave(Member member, Project project) {
//        // 탈퇴하려는 멤버의 id와 프로젝트 id
//        Long selectMemberId = member.getId();
//        Long selectProjectId = project.getId();
//
//        for (Map.Entry<Long, JoinProject> entry : joinProjectList.entrySet()) {
//            Long id = entry.getKey();
//            JoinProject joinProject = entry.getValue();
//
//            Long memberId = joinProject.getMemberId();
//            Long projectId = joinProject.getProjectId();
//
//            //조인 프로젝트 목록에서 탈퇴하려는 멤버 id와 프로젝트 id를 가지고 있는 조인 프로젝트를 찾아 id 삭제
//            if (memberId == selectMemberId && projectId == selectProjectId) {
//                joinProjectList.remove(id);
//            }
//        }
//    }
//
//    //멤버 기준 참여하고 있는 프로젝트 목록 찾기
//    @Override
//    public ArrayList<Long> findByMemberId(Member member) {
//
//        Long findMemberId = member.getId();
//
//        //프로젝트 목록
//        ArrayList<Long> projects = new ArrayList<>();
//
//        for (Map.Entry<Long, JoinProject> entry : joinProjectList.entrySet()) {
//            Long id = entry.getKey();
//            JoinProject joinProject = entry.getValue();
//
//            Long memberId = joinProject.getMemberId();
//
//            if (memberId == findMemberId) {
//                projects.add(id);
//            }
//        }
//        return projects;
//    }
//
//    //프로젝트 기준 참여하고 있는 멤버 목록 찾기
//    @Override
//    public ArrayList<Long> findByProjectId(Project project) {
//
//        Long findProjectId = project.getId();
//
//        //멤버 목록
//        ArrayList<Long> members = new ArrayList<>();
//
//        for (Map.Entry<Long, JoinProject> entry : joinProjectList.entrySet()) {
//            Long id = entry.getKey();
//            JoinProject joinProject = entry.getValue();
//
//            Long projectId = joinProject.getProjectId();
//
//            if (projectId == findProjectId) {
//                members.add(id);
//            }
//        }
//        return members;
//    }
//
//    @Override
//    public List<JoinProject> findAll() {
//        return new ArrayList<>(joinProjectList.values());
//    }

