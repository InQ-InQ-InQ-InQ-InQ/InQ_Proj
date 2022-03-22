package cteam.cteamproject.web.member.controller;

import cteam.cteamproject.domain.member.Member;
import cteam.cteamproject.domain.member.memberservice.MemberService;
import cteam.cteamproject.domain.relation.relationservice.RelationService;
import cteam.cteamproject.domain.project.Project;
import cteam.cteamproject.web.Success;
import cteam.cteamproject.web.member.form.MemberJoinForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final RelationService relationService;

    @GetMapping
    public List<Member> members() {
        return memberService.findMembers();
    }

    @GetMapping("/my-info")
    public Member myInfo(@SessionAttribute(name = "loginMember") Long memberId) {
        log.info("본인 정보 조회");
        return memberService.findById(memberId);
    }

    @GetMapping("/{memberId}")
    public Member member(@PathVariable Long memberId) {
        return memberService.findById(memberId);
    }

    @GetMapping("/joining-projects/my")
    public List<Project> getMyJoiningProjects(@SessionAttribute(name = "loginMember", required = false) Long memberId) {
        if (memberId == null) {
            log.info("세션없음");
            return null;
        }
        return relationService.findJoiningProjects(memberId);
    }

    @GetMapping("joining-projects/{memberId}")
    public List<Project> getJoiningProjects(@PathVariable Long memberId) {
        log.info("참여중인 프로젝트 조회");
        return relationService.findJoiningProjects(memberId);
    }

    @PostMapping("/join") //MemberJoinFormTest 상의 후에 바꾸기
    public Success join(@Validated @ModelAttribute MemberJoinForm memberForm) {

        Member member = new Member();
        member.setLoginId(memberForm.getLoginId());
        member.setPw(memberForm.getPw());
        member.setName(memberForm.getName());
        member.setPosition(memberForm.getPosition());
        member.setTechList(memberForm.getTechList());

        log.info("회원가입 성공 [{}]", member.getName());
        memberService.join(member);

        return new Success(true);
    }

    //데이터 수정, 일단 빼기로 함
//    @PostMapping("/edit")
//    public void edit(@SessionAttribute(name = "loginMember") Long memberId,
//                     @RequestBody Member updateParam) {
//        Member member = memberService.findById(memberId);
//        memberService.updateMember(member, updateParam);
//    }

    @PostMapping("/add-project/{projectId}")
    public Success addProject(@SessionAttribute(name = "loginMember") Long memberId, @PathVariable Long projectId) {
        relationService.addRelation(memberId, projectId);

        return new Success(true);
    }

    @PostMapping("/remove-project/{projectId}")
    public Success removeProject(@SessionAttribute(name = "loginMember") Long memberId, @PathVariable Long projectId) {
        relationService.removeRelation(memberId, projectId);

        return new Success(true);
    }
}
