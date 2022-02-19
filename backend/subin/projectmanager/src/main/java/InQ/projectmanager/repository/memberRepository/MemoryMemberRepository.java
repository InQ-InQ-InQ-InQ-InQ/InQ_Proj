package InQ.projectmanager.repository.memberRepository;

import InQ.projectmanager.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@RequiredArgsConstructor
public class MemoryMemberRepository implements MemberRepository {

    private static final Map<Long, Member> memberList = new ConcurrentHashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        memberList.put(member.getId(), member);

        return member;
    }

    @Override
    public void delete(Long id) {
        memberList.remove(id);
    }

    @Override
    public void update(Long id, Member updateParam) {
        Member findMember = findById(id);
        findMember.setName(updateParam.getName());
        findMember.setPosition(updateParam.getPosition());
    }

    @Override
    public Member findById(Long id) {
        return memberList.get(id);
    }

    @Override
    public Member findByName(String name) {
        return memberList.get(name);
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(memberList.values());
    }

    @Override
    public Optional<Member> findByLoginId(String loginId) {
        return memberList.values().stream()
                .filter(m -> m.getLoginId().equals(loginId))
                .findAny();
    }

    void clearStore() {
        memberList.clear();
    }

}