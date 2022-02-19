package InQ.projectmanager.service.memberService;

import InQ.projectmanager.domain.member.Member;
import InQ.projectmanager.repository.memberRepository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    //회원 가입
    @Override
    public Member join(Member member) {
        return memberRepository.save(member);
    }

    //회원 삭제
    @Override
    public void deleteMember(Member member) {
        memberRepository.delete(member.getId());
    }

    //회원 업데이트
    @Override
    public void updateMember(Member member, Member updateParam) {
        Long memberId = member.getId();
        memberRepository.update(memberId, updateParam);
    }

    //회원 아이디로 조회
    @Override
    public Member findById(Long id) {
        return memberRepository.findById(id);
    }

    //회원 이름으로 조회
    @Override
    public Member findByName(String name) {
        return memberRepository.findByName(name);
    }

    //회원 전체 조회
    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
}
