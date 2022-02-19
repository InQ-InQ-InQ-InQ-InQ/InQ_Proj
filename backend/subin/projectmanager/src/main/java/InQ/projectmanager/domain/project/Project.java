package InQ.projectmanager.domain.project;

import InQ.projectmanager.domain.member.Member;
import InQ.projectmanager.domain.Tech;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Project {

    private Long id;
    private String projectName;    // 프로젝트명
    private State state; // 프로젝트의 현 상태 (모집중, 진행중, 완료)
    private String details; // 프로젝트 소개글
    private String techList; // 필요 기술

    public Project() {
        state = State.RECRUIT;
    }

    public Project(String projectName, String details) {
        this.projectName = projectName;
        this.details = details;
        state = State.RECRUIT;
    }

    public Project(String projectName, String details, String techList) {
        this.projectName = projectName;
        this.details = details;
        this.techList = techList;
        state = State.RECRUIT;
    }
}