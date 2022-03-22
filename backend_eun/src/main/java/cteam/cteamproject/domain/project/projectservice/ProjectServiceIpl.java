package cteam.cteamproject.domain.project.projectservice;

import cteam.cteamproject.domain.project.PjStatus;
import cteam.cteamproject.domain.project.Project;
import cteam.cteamproject.domain.project.projectrepository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectServiceIpl implements ProjectService{

    private final ProjectRepository projectRepository;

    @Override
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Project project) {
        Long id = project.getId();
        projectRepository.delete(id);
    }

    @Override
    public void updateProject(Project project, Project updateParam) {
        Long id = project.getId();
        projectRepository.update(id, updateParam);
    }

    @Override
    public void updateProjectState(Project project, PjStatus state) {
        Long id = project.getId();
        projectRepository.updateState(id, state);
    }

    @Override
    public Project findById(Long id) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        return optionalProject.orElse(null);
    }

    @Override
    public Project findByName(String name) {
        Optional<Project> optionalProject = projectRepository.findByName(name);
        return optionalProject.orElse(null);
    }

    @Override
    public List<Project> findINGProject() {
        List<Project> projects = projectRepository.findAll();

        return projects.stream().filter(p -> p.getState().equals(PjStatus.ING))
                .collect(Collectors.toList());
    }

    @Override
    public List<Project> findFINProject() {
        List<Project> projects = projectRepository.findAll();

        return projects.stream().filter(p -> p.getState().equals(PjStatus.FIN))
                .collect(Collectors.toList());
    }

    @Override
    public List<Project> findRECRUITProject() {
        List<Project> projects = projectRepository.findAll();

        return projects.stream().filter(p -> p.getState().equals(PjStatus.RECRUIT))
                .collect(Collectors.toList());
    }

    @Override
    public List<Project> findProjects() {
        return projectRepository.findAll();
    }

}
