package InQ.projectmanager.service.memberService;

import InQ.projectmanager.domain.member.Member;

import java.util.List;

public interface MemberService {

    Member join(Member member);

    void deleteMember(Member member);

    void updateMember(Member member, Member updateParam);

    List<Member> findMembers();

    Member findById(Long id);

    Member findByName(String name);
}