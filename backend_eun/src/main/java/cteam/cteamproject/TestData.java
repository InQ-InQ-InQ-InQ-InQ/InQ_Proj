package cteam.cteamproject;

import cteam.cteamproject.domain.member.Member;
import cteam.cteamproject.domain.member.memberservice.MemberService;
import cteam.cteamproject.domain.project.Project;
import cteam.cteamproject.domain.project.projectservice.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestData {

    private final MemberService memberService;
    private final ProjectService projectService;

    @PostConstruct
    public void init() {

        memberService.join(new Member("test", "test!", "test", "BackEnd", "Spring"));

        projectService.addProject(new Project("TestProject", "TestProject", "Spring"));
    }
}
