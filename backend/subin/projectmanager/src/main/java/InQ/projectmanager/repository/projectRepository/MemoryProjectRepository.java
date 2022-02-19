package InQ.projectmanager.repository.projectRepository;

import InQ.projectmanager.domain.project.Project;
import InQ.projectmanager.domain.project.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@RequiredArgsConstructor
public class MemoryProjectRepository implements ProjectRepository {

    private static final Map<Long, Project> projectList = new ConcurrentHashMap<>();
    private static long sequence = 0L;

    @Override
    public Project save(Project project) {
        project.setId(++sequence);
        projectList.put(project.getId(), project);
        return project;
    }

    @Override
    public void delete(Long id) {
        projectList.remove(id);
    }

    @Override
    public void update(Long id, Project updateParam) {
        Project findProject = findById(id);
        findProject.setProjectName(updateParam.getProjectName());
        findProject.setDetails(updateParam.getDetails());
        findProject.setState(updateParam.getState());
        findProject.setTechList(updateParam.getTechList());
    }

    @Override
    public void updateState(Long id, State state) {
        Project project = projectList.get(id);

        project.setState(state);
    }

    @Override
    public Project findById(Long id) {
        return projectList.get(id);
    }

    @Override
    public Project findByProjectName(String projectName) {
        return projectList.get(projectName);
    }

    @Override
    public List<Project> findAll() {
        return new ArrayList<>(projectList.values());
    }

    @Override
    public Map<Long, Project> findState(State state) {
        Map<Long, Project> stateProjectList = new HashMap<>();
        for(Project project : projectList.values()) {
            if (project.getState().equals(state)) {
                stateProjectList.put(project.getId(), project);
            }
        }
        return stateProjectList;
    }

    public void clearStore() {
        projectList.clear();
    }
}
