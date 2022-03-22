package cteam.cteamproject.domain.project.projectservice;

import cteam.cteamproject.domain.project.PjStatus;
import cteam.cteamproject.domain.project.Project;

import java.util.List;

public interface ProjectService {

    Project addProject(Project project);

    void deleteProject(Project project);

    void updateProject(Project project, Project updateParam);

    void updateProjectState(Project project, PjStatus state);

    Project findById(Long id);

    Project findByName(String name);

    List<Project> findINGProject();

    List<Project> findFINProject();

    List<Project> findRECRUITProject();

    List<Project> findProjects();
}
