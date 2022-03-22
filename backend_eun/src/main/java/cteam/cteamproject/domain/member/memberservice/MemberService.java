package cteam.cteamproject.domain.member.memberservice;

import cteam.cteamproject.domain.member.Member;

import java.util.List;

public interface MemberService {

    Member join(Member member);

    void deleteMember(Member member);

    void updateMember(Member member, Member updateParam);

    Member findById(Long id);

    Member findByName(String name);

    List<Member> findMembers();
}
