//package InQ.projectmanager.controller;
//
//import InQ.projectmanager.Success;
//import InQ.projectmanager.domain.member.Member;
//import InQ.projectmanager.domain.project.Project;
//import InQ.projectmanager.service.relationService.RelationServiceImpl;
//import InQ.projectmanager.service.memberService.MemberServiceImpl;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/members")
//public class MemberController {
//
//    @Autowired
//    MemberServiceImpl memberService;
//    @Autowired
//    RelationServiceImpl joinProjectService;
//
//    @GetMapping
//    public List<Member> members() {
//        return memberService.findMembers();
//    }
//
//    @GetMapping("/my-info")
//    public Member myInfo(@SessionAttribute(name = "loginMember") Long memberId) {
//        log.info("본인 정보 조회");
//        return memberService.findMemberId(memberId);
//    }
//
//    @GetMapping("/{memberId}")
//    public Member member(@PathVariable Long memberId) {
//        return memberService.findMemberId(memberId);
//    }
//
//    @GetMapping("/joining-projects/my")
//    public List<Project> getMyJoiningProjects(@SessionAttribute(name = "loginMember") Long memberId) {
//        return joinProjectService.findJoinProjectByMemberId(memberId);
//    }
//
//    @GetMapping("joining-projects/{memberId}")
//    public List<Project> getJoiningProjects(@PathVariable Long memberId) {
//        log.info("참여중인 프로젝트 조회");
//        return RelationServiceImpl.findJoiningProjects(memberId);
//    }
//
//    @PostMapping("/join") //MemberJoinFormTest 상의 후에 바꾸기
//    public Success join(@Validated @ModelAttribute MemberJoinForm memberForm) {
//
//        Member member = new Member();
//        member.setLoginId(memberForm.getLoginId());
//        member.setPw(memberForm.getPw());
//        member.setName(memberForm.getName());
//        member.setPosition(memberForm.getPosition());
//        member.setTechList(memberForm.getTechList());
//
//        log.info("회원가입 성공 [{}]", member.getName());
//        memberService.join(member);
//
//        return new Success(true);
//    }
//
//    @PostMapping("/add-project/{projectId}")
//    public Success addProject(@SessionAttribute(name = "loginMember") Long memberId, @PathVariable Long projectId) {
//        RelationServiceImpl.addRelation(memberId, projectId);
//
//        return new Success(true);
//    }
//
//    @PostMapping("/remove-project/{projectId}")
//    public Success removeProject(@SessionAttribute(name = "loginMember") Long memberId, @PathVariable Long projectId) {
//        RelationServiceImpl.removeRelation(memberId, projectId);
//
//        return new Success(true);
//    }
//
//
//}
