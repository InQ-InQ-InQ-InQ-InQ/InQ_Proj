package cteam.cteamproject.domain.relation.relationrepository;

import cteam.cteamproject.domain.relation.Relation;

import java.util.List;

public interface RelationRepository {

    void addRelation(Long memberId, Long projectId);

    void removeRelation(Long memberId, Long projectId);

    List<Relation> findAll();
}
