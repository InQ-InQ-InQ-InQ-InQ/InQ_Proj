package cteam.cteamproject.domain.project.projectrepository;

import cteam.cteamproject.domain.project.PjStatus;
import cteam.cteamproject.domain.project.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {

    Project save(Project project);

    void delete(Long id);

    void update(Long id, Project updateParam);

    void updateState(Long id, PjStatus state);

    Optional<Project> findById(Long id);

    Optional<Project> findByName(String name);

    List<Project> findAll();
}
