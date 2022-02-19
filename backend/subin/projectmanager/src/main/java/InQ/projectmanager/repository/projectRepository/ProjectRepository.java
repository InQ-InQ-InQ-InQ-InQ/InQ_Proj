package InQ.projectmanager.repository.projectRepository;

import InQ.projectmanager.domain.project.Project;
import InQ.projectmanager.domain.project.State;

import java.util.List;
import java.util.Map;

public interface ProjectRepository {
    Project save(Project project);

    void delete(Long id);

    void update(Long id, Project updateParam);

    void updateState(Long id, State state);

    Project findById(Long id);

    Project findByProjectName(String projectName);

    List<Project> findAll();

    Map<Long, Project> findState(State state);

}
