package cteam.cteamproject.domain.member.memberservice;

import cteam.cteamproject.domain.member.Member;
import cteam.cteamproject.domain.member.memberrepository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceIpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member join(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(Member member) {
        Long id = member.getId();
        memberRepository.delete(id);
    }

    @Override
    public void updateMember(Member member, Member updateParam) {
        Long id = member.getId();
        memberRepository.update(id, updateParam);
    }

    @Override
    public Member findById(Long id) {
        Optional<Member> optionalMember = memberRepository.findById(id);
        return optionalMember.orElse(null);
    }

    @Override
    public Member findByName(String name) {
        Optional<Member> optionalMember = memberRepository.findByName(name);
        return optionalMember.orElse(null);
    }

    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

}
