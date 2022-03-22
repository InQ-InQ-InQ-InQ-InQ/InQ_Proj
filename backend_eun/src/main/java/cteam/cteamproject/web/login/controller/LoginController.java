package cteam.cteamproject.web.login.controller;

import cteam.cteamproject.domain.login.LoginService;
import cteam.cteamproject.domain.member.Member;
import cteam.cteamproject.web.Success;
import cteam.cteamproject.web.exception.ErrorResult;
import cteam.cteamproject.web.login.form.LoginForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/login")
    public Success login(@Validated @ModelAttribute LoginForm loginForm, BindingResult bindingResult, HttpServletRequest request) throws BindException {

        if (bindingResult.hasErrors()) {
            log.info("아이디 혹은 비밀번호를 입력해주세요.");
            throw new BindException(bindingResult);
        }

        Member member = loginService.login(loginForm.getLoginId(), loginForm.getPw());
        //object 에러 처리
        if (member == null) {
            log.info("아이디 혹은 비밀번호 틀림");
            bindingResult.reject("loginFail", "아이디 혹은 비밀번호를 잘못 입력 하셨습니다.");
            throw new BindException(bindingResult);
        }

        //성공 로직
        HttpSession session = request.getSession();
        session.setAttribute("loginMember", member.getId());
        log.info("로그인 성공");
        return new Success(true);
    }

    @PostMapping("logout")
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
            log.info("로그아웃 완료, 세션 삭제");
        }

        else log.info("로그아웃 완료, 세션이 이미 없음"); //세션이 만료되었을 때 딱히 의미 없는 코드
    }
}
