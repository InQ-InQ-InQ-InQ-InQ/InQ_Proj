//package InQ.projectmanager.service.memberService;
//
//import InQ.projectmanager.domain.Tech;
//import InQ.projectmanager.domain.member.Member;
//import InQ.projectmanager.domain.member.Position;
//import InQ.projectmanager.repository.memberRepository.MemberRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class MemberServiceTest {
//
//    @Autowired MemberService memberService;
//    @Autowired MemberRepository memberRepository;
//
//    @Test
//    public void 회원가입() throws Exception {
//        //given
//        Member member = createMember();
//
//        //when
//        Long savedId = memberService.join(member);
//
//        //then
//        System.out.println("savedId = " + savedId);
//        System.out.println("memberId = " + member.getId());
//        assertEquals(member, memberRepository.findById(savedId));
//    }
//
//    @Test
//    public void 회원수정() throws Exception {
//        //given
//        Member member = createMember();
//
//        //when
//        member.setName("수정회원1");
//        member.setPosition(Position.FE);
//
//        Long savedId = memberService.join(member);
//        //수정회원
//        Member updateMember = memberRepository.findById(savedId);
//
//        //then
//        System.out.println("memberName = " + member.getName());
//        System.out.println("updateMemberName = " + updateMember.getName());
//        System.out.println("******************************************");
//        System.out.println("memberPosition = " + member.getPosition());
//        System.out.println("updateMemberPosition = " + updateMember.getPosition());
//        assertEquals("수정회원1", updateMember.getName());
//        assertEquals(Position.FE, updateMember.getPosition());
//    }
//
//    private Member createMember() {
//        Member member = new Member();
//        member.setId(1L);
//        member.setName("회원1");
//        member.setPosition(Position.BE);
//        member.setTechList(new ArrayList<Tech>(Arrays.asList(Tech.Spring, Tech.HTML)));
//
//        return member;
//    }
//
//
//}