package cteam.cteamproject.domain.project.projectrepository;

import cteam.cteamproject.domain.project.PjStatus;
import cteam.cteamproject.domain.project.Project;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemoryProjectRepository implements ProjectRepository {

    private static final Map<Long, Project> projectStore = new ConcurrentHashMap<>();
    private static Long sequence = 0L;

    @Override
    public Project save(Project project) {
        project.setId(++sequence);
        projectStore.put(project.getId(), project);

        return projectStore.get(project.getId());
    }

    @Override
    public void delete(Long id) {
        projectStore.remove(id);
    }

    @Override
    public void update(Long id, Project updateParam) {
        Project project = projectStore.get(id);

        project.setProjectName(updateParam.getProjectName());
        project.setDetails(updateParam.getDetails());
        project.setState(updateParam.getState());
        project.setTechList(updateParam.getTechList());
    }

    @Override
    public void updateState(Long id, PjStatus state) {
        Project project = projectStore.get(id);

        project.setState(state);
    }

    @Override
    public Optional<Project> findById(Long id) {
        Project project = projectStore.get(id);
        return Optional.ofNullable(project);
    }

    @Override
    public Optional<Project> findByName(String name) {
        return projectStore.values().stream()
                .filter(p -> p.getProjectName().equals(name))
                .findAny();
    }

    @Override
    public List<Project> findAll() {
        return new ArrayList<>(projectStore.values());
    }

    public void clearStore() {
        projectStore.clear();
    }
}
