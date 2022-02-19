package InQ.projectmanager.domain.member;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class Member {

    private Long id;
    private String loginId;
    private String pw;
    private String name;
    private String position;
    //private Position position;
    private String techList;

    public Member(String loginId, String pw, String name, String position, String techList) {
        this.loginId = loginId;
        this.pw = pw;
        this.name = name;
        this.position = position;
        this.techList = techList;
    }

    public Member() {
    }
}