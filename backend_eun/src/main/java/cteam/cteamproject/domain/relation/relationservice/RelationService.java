package cteam.cteamproject.domain.relation.relationservice;

import cteam.cteamproject.domain.member.Member;
import cteam.cteamproject.domain.project.Project;

import java.util.List;

public interface RelationService {

    void addRelation(Long memberId, Long projectId);

    void removeRelation(Long memberId, Long projectId);

    List<Project> findJoiningProjects(Long memberId);

    List<Member> findJoinedMembers(Long projectId);
}
