package InQ.projectmanager.repository.memberRepository;

import InQ.projectmanager.domain.member.Member;
import InQ.projectmanager.domain.project.Project;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    void delete(Long id);

    void update(Long id, Member updateParam);

    Member findById(Long id);

    Member findByName(String name);

    Optional<Member> findByLoginId(String loginId);

    List<Member> findAll();
}
