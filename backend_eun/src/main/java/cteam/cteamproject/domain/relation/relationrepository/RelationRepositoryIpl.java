package cteam.cteamproject.domain.relation.relationrepository;

import cteam.cteamproject.domain.relation.Relation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RelationRepositoryIpl implements RelationRepository{

    private static final List<Relation> relationList = new ArrayList<>();

    @Override
    public void addRelation(Long memberId, Long projectId) {
        Relation relation = new Relation(memberId, projectId);
        relationList.add(relation);
    }

    @Override
    public void removeRelation(Long memberId, Long projectId) {
        relationList.removeIf(relation -> relation.getMemberId().equals(memberId) && relation.getProjectId().equals(projectId));
    }

    @Override
    public List<Relation> findAll() {
        return relationList;
    }

    public void clear() {
        relationList.clear();
    }
}
