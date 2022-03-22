package cteam.cteamproject.domain.relation.relationservice;

import cteam.cteamproject.domain.member.Member;
import cteam.cteamproject.domain.member.memberrepository.MemoryMemberRepository;
import cteam.cteamproject.domain.member.memberservice.MemberService;
import cteam.cteamproject.domain.member.memberservice.MemberServiceIpl;
import cteam.cteamproject.domain.relation.Relation;
import cteam.cteamproject.domain.relation.relationrepository.RelationRepositoryIpl;
import cteam.cteamproject.domain.project.Project;
import cteam.cteamproject.domain.project.projectrepository.MemoryProjectRepository;
import cteam.cteamproject.domain.project.projectservice.ProjectService;
import cteam.cteamproject.domain.project.projectservice.ProjectServiceIpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RelationServiceIplTest {

    private final RelationRepositoryIpl relationRepository = new RelationRepositoryIpl();
    private final ProjectService projectService = new ProjectServiceIpl(new MemoryProjectRepository());
    private final MemberService memberService = new MemberServiceIpl(new MemoryMemberRepository());
    private final RelationService relationService = new RelationServiceIpl(relationRepository, projectService, memberService);

    @AfterEach
    void afterEach() {
        relationRepository.clear();
    }

    @Test
    void addRelation() {
        relationService.addRelation(1L, 1L);

        List<Relation> relations = relationRepository.findAll();
        assertThat(relations.size()).isEqualTo(1);
        assertThat(relations.get(0).getMemberId()).isEqualTo(1L);
        assertThat(relations.get(0).getProjectId()).isEqualTo(1L);
    }

    @Test
    void removeRelation() {
        relationService.addRelation(1L, 1L);
        relationService.removeRelation(1L, 1L);

        List<Relation> relations = relationRepository.findAll();
        assertThat(relations.size()).isEqualTo(0);
    }

    @Test
    void findJoiningProjects() {
        Project project1 = new Project();
        Project project2 = new Project();
        projectService.addProject(project1);
        projectService.addProject(project2);

        relationService.addRelation(1L, 1L);
        relationService.addRelation(1L, 2L);

        List<Project> joiningProjects = relationService.findJoiningProjects(1L);
        assertThat(joiningProjects).contains(project1, project2);
    }

    @Test
    void findJoinedMembers() {
        Member member1 = new Member();
        Member member2 = new Member();
        memberService.join(member1);
        memberService.join(member2);

        relationService.addRelation(1L, 1L);
        relationService.addRelation(2L, 1L);

        List<Member> joinedMembers = relationService.findJoinedMembers(1L);
        assertThat(joinedMembers).contains(member1, member2);
    }
}