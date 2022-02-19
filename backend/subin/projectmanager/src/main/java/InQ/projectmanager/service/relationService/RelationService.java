package InQ.projectmanager.service.relationService;

import InQ.projectmanager.domain.member.Member;
import InQ.projectmanager.domain.project.Project;

import java.util.List;

public interface RelationService {

    void addRelation(Long memberId, Long projectId);

    void removeRelation(Long memberId, Long projectId);

    List<Project> findJoiningProjects(Long memberId);

    List<Member> findJoinedMembers(Long projectId);
}