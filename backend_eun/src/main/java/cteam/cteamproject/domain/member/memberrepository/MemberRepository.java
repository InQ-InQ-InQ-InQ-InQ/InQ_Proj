package cteam.cteamproject.domain.member.memberrepository;

import cteam.cteamproject.domain.member.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    void delete(Long id);

    void update(Long id, Member updateParam);

    Optional<Member> findById(Long id);

    Optional<Member> findByName(String name);

    Optional<Member> findByLoginId(String loginId);

    List<Member> findAll();
}
