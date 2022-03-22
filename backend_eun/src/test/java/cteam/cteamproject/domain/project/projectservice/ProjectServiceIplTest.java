//package cteam.cteamproject.domain.project.projectService;
//
//import cteam.cteamproject.domain.member.Member;
//import cteam.cteamproject.domain.member.Position;
//import cteam.cteamproject.domain.project.PjStatus;
//import cteam.cteamproject.domain.project.Project;
//import cteam.cteamproject.domain.project.projectRepository.MemoryProjectRepository;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.NoSuchElementException;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class ProjectServiceIplTest {
//
////    private final MemoryProjectRepository memoryProjectRepository = new MemoryProjectRepository();
////    private final ProjectService projectService = new ProjectServiceIpl(memoryProjectRepository);
//
//    private final MemoryProjectRepository memoryProjectRepository;
//    private final ProjectService projectService;
//
//    @Autowired
//    public ProjectServiceIplTest(MemoryProjectRepository memoryProjectRepository, ProjectService projectService) {
//        this.memoryProjectRepository = memoryProjectRepository;
//        this.projectService = projectService;
//    }
//
//    Member member = new Member("userA", Position.BackEnd, new ArrayList<>());
//    Project project = new Project("projectA", "good");
//
//    @AfterEach
//    void afterEach() {
//        memoryProjectRepository.clearStore();
//    }
//
//    @Test
//    void join() {
//        //given
//        //when
//        projectService.addProject(project);
//        //then
//        Long id = project.getId();
//        Project result = projectService.findById(id);
//
//        assertThat(result).isEqualTo(project);
//    }
//
//    @Test
//    void deleteProject() {
//        //given
//        projectService.addProject(project);
//        //when
//        projectService.deleteProject(project);
//        //then
//        Long id = project.getId();
//        assertThrows(NoSuchElementException.class, () -> projectService.findById(id));
//    }
//
//    @Test
//    void updateProject() {
//        //given
//        projectService.addProject(project);
//        Project project1 = new Project("projectB", "bad");
//        //when
//        projectService.updateProject(project, project1);
//        //then
//        Project result = projectService.findById(this.project.getId());
//        assertThat(result.getProjectName()).isEqualTo(project1.getProjectName());
//        assertThat(result.getExplain()).isEqualTo(project1.getExplain());
//    }
//
//    @Test
//    void findProjectByName() {
//        //given
//        projectService.addProject(project);
//        //when
//        Project result = projectService.findById(this.project.getProjectName());
//        //then
//        assertThat(result).isEqualTo(project);
//    }
//
//    @Test
//    void findINGProject() {
//        //given
//        Project project1 = new Project("A", "");
//        Project project2 = new Project("A", "");
//        Project project3 = new Project("A", "");
//        project2.setPjStatus(PjStatus.FIN);
//        projectService.addProject(project1);
//        projectService.addProject(project2);
//        projectService.addProject(project3);
//        //when
//        List<Project> ingProject = projectService.findINGProject();
//        //then
//        assertThat(ingProject).doesNotContain(project2);
//        assertThat(ingProject).contains(project1, project3);
//    }
//
//    @Test
//    void findFINProject() {
//        //given
//        Project project1 = new Project("A", "");
//        Project project2 = new Project("A", "");
//        Project project3 = new Project("A", "");
//        project2.setPjStatus(PjStatus.FIN);
//        projectService.addProject(project1);
//        projectService.addProject(project2);
//        projectService.addProject(project3);
//        //when
//        List<Project> finProject = projectService.findFINProject();
//        //then
//        assertThat(finProject).doesNotContain(project1, project3);
//    }
//
//    @Test
//    void findFAILProject() {
//        //given
//        Project project1 = new Project("A", "");
//        Project project2 = new Project("A", "");
//        Project project3 = new Project("A", "");
//        project2.setPjStatus(PjStatus.FAIL);
//        projectService.addProject(project1);
//        projectService.addProject(project2);
//        projectService.addProject(project3);
//        //when
//        List<Project> failProject = projectService.findFAILProject();
//        //then
//        assertThat(failProject).doesNotContain(project1, project3);
//    }
//
//    @Test
//    void findProjects() {
//        //given
//        Project project1 = new Project("A", "");
//        Project project2 = new Project("A", "");
//        Project project3 = new Project("A", "");
//        projectService.addProject(project1);
//        projectService.addProject(project2);
//        projectService.addProject(project3);
//        //when
//        List<Project> projects = projectService.findProjects();
//        //then
//        assertThat(projects.size()).isEqualTo(3);
//        assertThat(projects).contains(project1, project2, project3);
//    }
//
//    @Test
//    void addMember() {
//        //given
//        projectService.addProject(project);
//        //when
//        projectService.addMember(project, member);
//        //then
//        Project savedProject = projectService.findById(project.getId());
//        List<Member> memberList = savedProject.getMemberList();
//        assertThat(memberList).contains(member);
//    }
//
//    @Test
//    void removeMember() {
//        //given
//        projectService.addProject(project);
//        projectService.addMember(project, member);
//        //when
//        projectService.removeMember(project, member);
//        //then
//        Project savedProject = projectService.findById(this.project.getId());
//        List<Member> memberList = savedProject.getMemberList();
//        assertThat(memberList).doesNotContain(member);
//    }
//}