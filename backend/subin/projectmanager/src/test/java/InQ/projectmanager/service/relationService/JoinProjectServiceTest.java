//package InQ.projectmanager.service.joinProjectService;
//
//import InQ.projectmanager.domain.relation.JoinProject;
//import InQ.projectmanager.domain.member.Member;
//import InQ.projectmanager.domain.project.Project;
//import InQ.projectmanager.domain.project.State;
//import InQ.projectmanager.repository.relationRepository.relationRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@SpringBootTest
//class JoinProjectServiceTest {
//
//    @Autowired
//    relationRepository joinProjectRepository;
//    @Autowired JoinProjectService joinProjectService;
//
//    @Test
//    public void 프로젝트_참가() throws Exception {
//        //given
//        //멤버와 프로젝트가 주어짐
//        Member member = createMember();
//        Project project = createProject1(); //State = RECRUIT
//
//        //when
//        joinProjectService.joinProject(member, project);
//
//        //then
//        //JoinProject가 추가되어야 함
//        System.out.println("*************************");
//        List<JoinProject> all = joinProjectRepository.findAll();
//        System.out.println("all = " + all);
//        System.out.println("*************************");
//        ArrayList<Long> projectId = joinProjectRepository.findByProjectId(project);
//        System.out.println("projectId = " + projectId);
//        System.out.println("*************************");
//    }
//
//    @Test
//    public void 프로젝트_참가실패() throws Exception {
//        //given
//        //멤버와 프로젝트가 주어짐
//        Member member = createMember();
//        Project project = createProject2(); //State = COMPLETE
//
//        //when
//        joinProjectService.joinProject(member, project);
//
//        //then
//        //JoinProject가 추가되지 않아 joinProjectRepository가 비어 있어야 함
//        System.out.println("*************************");
//        List<JoinProject> all = joinProjectRepository.findAll();
//        System.out.println("all = " + all);
//        System.out.println("*************************");
//        ArrayList<Long> projectId = joinProjectRepository.findByProjectId(project);
//        System.out.println("projectId = " + projectId);
//        System.out.println("*************************");
//    }
//
//    private Member createMember() {
//        Member member = new Member();
//        member.setId(1L);
//        member.setName("회원1");
//
//
//        return member;
//    }
//
//    private Project createProject1() {
//        Project project = new Project();
//        project.setId(1L);
//        project.setProjectName("프로젝트A");
//        project.setDetails("게시판 관리 프로젝트입니다.");
//        project.setState(State.RECRUIT);
//
//
//        return project;
//    }
//
//    private Project createProject2() {
//        Project project = new Project();
//        project.setId(2L);
//        project.setProjectName("프로젝트B");
//        project.setDetails("학사 관리 프로젝트입니다.");
//
//
//        return project;
//    }
//
//
//
//}