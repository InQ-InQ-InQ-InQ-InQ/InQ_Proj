package cteam.cteamproject.web.project.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class ProjectAddForm {

    @NotEmpty(message = "프로젝트 이름은 필수입니다.")
    private String projectName;

    private String techList;

    @NotEmpty(message = "프로젝트 설명은 필수입니다.")
    private String details;
}
