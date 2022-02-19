package InQ.projectmanager.controller;

import InQ.projectmanager.domain.member.Member;
import InQ.projectmanager.login.LoginForm;
import InQ.projectmanager.service.loginService.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public Boolean login(@Validated @RequestBody LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request) {
            if (bindingResult.hasErrors()) {
            log.info("아이디 혹은 비밀번호 입력안함");
            log.info("errors={}", bindingResult);
            return false;
        }

        Member member = loginService.login(loginForm.getLoginId(), loginForm.getPw());
        //object 에러 처리
        if (member == null) {
            log.info("아이디 혹은 비밀번호 틀림");
            bindingResult.reject("loginFail", "아이디 혹은 비밀번호를 잘못 입력 하셨습니다.");
            return false;
        }

        //성공 로직
        HttpSession session = request.getSession();
        session.setAttribute("loginMember", member.getId());
        log.info("로그인 성공");
        return true;
    }

    @PostMapping("logout")
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            log.info("로그아웃 완료, 세션 삭제");
            session.invalidate();
        }

        else log.info("로그아웃 완료, 세션이 이미 없음"); //세션이 만료되었을 때 딱히 의미 없는 코드
    }
}
