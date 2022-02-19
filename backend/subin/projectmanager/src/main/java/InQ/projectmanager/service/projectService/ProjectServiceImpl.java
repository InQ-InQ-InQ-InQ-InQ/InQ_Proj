package InQ.projectmanager.service.projectService;

import InQ.projectmanager.domain.project.Project;
import InQ.projectmanager.domain.project.State;
import InQ.projectmanager.repository.projectRepository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;

    //프로젝트 추가
    @Override
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    //프로젝트 삭제
    @Override
    public void deleteProject(Project project) {
        projectRepository.delete(project.getId());
    }

    //프로젝트 업데이트
    @Override
    public void updateProject(Project project, Project updateParam) {
        Long projectId = project.getId();
        projectRepository.update(projectId, updateParam);
    }

    //프로젝트 상태 업데이트
    @Override
    public void updateProjectState(Project project, State state) {
        Long id = project.getId();
        projectRepository.updateState(id, state);
    }

    //프로젝트 아이디로 조회
    @Override
    public Project findById (Long id) {
        return projectRepository.findById(id);
    }

    //프로젝트 이름으로 조회
    @Override
    public Project findByName (String name) {
        return projectRepository.findByProjectName(name);
    }

    //프로젝트 전체 조회
    @Override
    public List<Project> findProjects() {
        return projectRepository.findAll();
    }



    //진행중인 프로젝트 조회
    @Override
    public List<Project> findINGProject() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream().filter(p -> p.getState().equals(State.ING))
                .collect(Collectors.toList());
    }

    //완료된 프로젝트 조회
    @Override
    public List<Project> findFINProject() {
        List<Project> projects = projectRepository.findAll();

        return projects.stream().filter(p -> p.getState().equals(State.FIN))
                .collect(Collectors.toList());
    }

    //모집중인 프로젝트 조회
    @Override
    public List<Project> findRECRUITProject() {
        List<Project> projects = projectRepository.findAll();

        return projects.stream().filter(p -> p.getState().equals(State.RECRUIT))
                .collect(Collectors.toList());
    }

//    //프로젝트 상태로 조회
//    @Override
//    public Map<Long, Project> findProjectState(State state) {
//        return projectRepository.findState(state);
//    }
}
