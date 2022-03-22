//package cteam.cteamproject.domain.project.projectRepository;
//
//import cteam.cteamproject.domain.project.Project;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class MemoryProjectRepositoryTest {
//
//    MemoryProjectRepository memoryProjectRepository = new MemoryProjectRepository();
//
//    @AfterEach
//    void afterEach() {
//        memoryProjectRepository.clearStore();
//    }
//
//    @Test
//    void save() {
//        //given
//        Project project = new Project("projectA", "good");
//        //when
//        Project savedProject = memoryProjectRepository.save(project);
//        //then
//        assertThat(project.getProjectName()).isEqualTo(savedProject.getProjectName());
//    }
//
//    @Test
//    void delete() {
//        //given
//        Project project = new Project("projectA", "good");
//        memoryProjectRepository.save(project);
//        //when
//        memoryProjectRepository.delete(project.getId());
//        //then
//        Optional<Project> optionalProject = memoryProjectRepository.findById(project.getId());
//        assertThat(optionalProject.isEmpty()).isEqualTo(true);
//    }
//
//    @Test
//    void update() {
//        //given
//        Project project1 = new Project("projectA", "good");
//        Project project2 = new Project("projectB", "bad");
//        memoryProjectRepository.save(project1);
//        //when
//        memoryProjectRepository.update(project1.getId(), project2);
//        //then
//        assertThat(project1.getProjectName()).isEqualTo(project2.getProjectName());
//    }
//
//    @Test
//    void findByName() {
//        //given
//        Project project = new Project("projectA", "good");
//        memoryProjectRepository.save(project);
//        //when
//        Optional<Project> optionalProject = memoryProjectRepository.findByName(project.getProjectName());
//        //then
//        Project result = optionalProject.orElseThrow();
//        assertThat(project.getProjectName()).isEqualTo(result.getProjectName());
//    }
//
//    @Test
//    void findAll() {
//        //given
//        Project project1 = new Project("projectA", "good");
//        Project project2 = new Project("projectB", "bad");
//        memoryProjectRepository.save(project1);
//        memoryProjectRepository.save(project2);
//        //when
//        List<Project> projects = memoryProjectRepository.findAll();
//        //then
//        assertThat(projects.size()).isEqualTo(2);
//        assertThat(projects).contains(project1, project2);
//    }
//}