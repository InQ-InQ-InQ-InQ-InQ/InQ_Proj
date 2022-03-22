package cteam.cteamproject.domain.relation;

import lombok.Getter;

@Getter
public class Relation {

    private final Long memberId;

    private final Long projectId;

    public Relation(Long memberId, Long projectId) {
        this.memberId = memberId;
        this.projectId = projectId;
    }
}
