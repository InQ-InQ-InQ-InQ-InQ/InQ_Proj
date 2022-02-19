package InQ.projectmanager.domain.relation;

import InQ.projectmanager.domain.member.Member;
import InQ.projectmanager.domain.project.Project;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Relation {

//    private Long id;

    private Long memberId;

    private Long projectId;

    public Relation(Long memberId, Long projectId) {
        this.memberId = memberId;
        this.projectId = projectId;
    }
}