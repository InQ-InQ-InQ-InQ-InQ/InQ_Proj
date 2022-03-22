package cteam.cteamproject.domain.project;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Project {

    private Long id;
    private String projectName;
    private PjStatus state;
    private String details;
    private String techList;

    public Project() {
        state = PjStatus.RECRUIT;
    }

    public Project(String projectName, String details) {
        this.projectName = projectName;
        this.details = details;
        state = PjStatus.RECRUIT;
    }

    public Project(String projectName, String details, String techList) {
        this.projectName = projectName;
        this.details = details;
        this.techList = techList;
        state = PjStatus.RECRUIT;
    }


}
