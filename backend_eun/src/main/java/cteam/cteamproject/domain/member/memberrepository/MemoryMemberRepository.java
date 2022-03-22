package cteam.cteamproject.domain.member.memberrepository;

import cteam.cteamproject.domain.member.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static final Map<Long, Member> memberStore = new ConcurrentHashMap<>();
    private static Long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        memberStore.put(member.getId(), member);

        return memberStore.get(member.getId());
    }

    @Override
    public void delete(Long id) {
        memberStore.remove(id);
    }

    @Override
    public void update(Long id, Member updateParam) {
        Member member = memberStore.get(id);
        member.setName(updateParam.getName());
        member.setPosition(updateParam.getPosition());
        member.setTechList(updateParam.getTechList());
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = memberStore.get(id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        return memberStore.values().stream()
                .filter(m -> m.getName().equals(name))
                .findAny();
    }

    @Override
    public Optional<Member> findByLoginId(String loginId) {
        return memberStore.values().stream()
                .filter(m -> m.getLoginId().equals(loginId))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(memberStore.values());
    }

    void clearStore() {
        memberStore.clear();
    }
}
