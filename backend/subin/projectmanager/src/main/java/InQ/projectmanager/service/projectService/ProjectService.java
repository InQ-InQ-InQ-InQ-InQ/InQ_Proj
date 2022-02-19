package InQ.projectmanager.service.projectService;

import InQ.projectmanager.domain.project.Project;
import InQ.projectmanager.domain.project.State;

import java.util.List;
import java.util.Map;

public interface ProjectService {

    Project addProject(Project project);

    void deleteProject(Project project);

    void updateProject(Project project, Project updateParam);

    void updateProjectState(Project project, State state);

    Project findById(Long id);

    Project findByName(String name);

    List<Project> findProjects();

    List<Project> findINGProject();

    List<Project> findFINProject();

    List<Project> findRECRUITProject();

//    Map<Long, Project> findProjectState();


}
