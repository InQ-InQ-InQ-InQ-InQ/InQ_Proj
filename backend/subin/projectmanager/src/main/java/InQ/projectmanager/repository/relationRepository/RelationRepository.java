package InQ.projectmanager.repository.relationRepository;

import InQ.projectmanager.domain.member.Member;
import InQ.projectmanager.domain.project.Project;
import InQ.projectmanager.domain.relation.Relation;

import java.util.ArrayList;
import java.util.List;

public interface RelationRepository {

    void addRelation(Long memberId, Long projectId);

    void removeRelation(Long memberId, Long projectId);

    List<Relation> findAll();

//    Relation join(Member member, Project project);
//
//    void delete(Long id);
//
//    void leave(Member member, Project project);
//
//    ArrayList<Long> findByMemberId(Member member);
//
//    ArrayList<Long> findByProjectId(Project project);

}
