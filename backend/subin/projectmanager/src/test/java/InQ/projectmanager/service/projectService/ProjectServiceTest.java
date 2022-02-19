//package InQ.projectmanager.service.projectService;
//
//import InQ.projectmanager.domain.Tech;
//import InQ.projectmanager.domain.project.Project;
//import InQ.projectmanager.domain.project.State;
//import InQ.projectmanager.repository.projectRepository.ProjectRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class ProjectServiceTest {
//
//    @Autowired
//    ProjectServiceImpl projectService;
//    @Autowired ProjectRepository projectRepository;
//
//    @Test
//    public void 프로젝트_생성() throws Exception {
//        //given
//        Project project = createProject1();
//
//        //when
//        Long newProjectId = projectService.join(project);
//
//        //then
//        System.out.println("newProjectId = " + newProjectId);
//        System.out.println("project.getId() = " + project.getId());
//        assertEquals(project, projectRepository.findById(newProjectId));
//    }
//
//    @Test
//    public void 프로젝트_수정() throws Exception {
//        //given
//        Project project = createProject1();
//
//        System.out.println("projectName = " + project.getProjectName());
//        System.out.println("projectState() = " + project.getState());
//
//        //when
//        project.setProjectName("수정된 프로젝트 A");
//        project.setState(State.COMPLETE);
//
//        Long updateProjectId = projectService.join(project);
//
//        Project updateProject = projectRepository.findById(updateProjectId);
//
//        //then
//        System.out.println("수정 후");
//        System.out.println("projectName = " + project.getProjectName());
//        System.out.println("updateProjectName = " + updateProject.getProjectName());
//        System.out.println("******************************************");
//        System.out.println("projectState = " + project.getState());
//        System.out.println("updateProjectState = " + updateProject.getState());
//
//        assertEquals("수정된 프로젝트 A", updateProject.getProjectName());
//        assertEquals(State.COMPLETE, updateProject.getState());
//    }
//
//    private Project createProject1() {
//        Project project = new Project();
//        project.setId(1L);
//        project.setProjectName("프로젝트 A");
//        project.setDetails("게시판 관리 프로젝트입니다.");
//        project.setState(State.RECRUIT);
//        project.setTechList(new ArrayList<Tech>(Arrays.asList(Tech.Spring, Tech.HTML, Tech.CSS)));
//
//        return project;
//    }
//}