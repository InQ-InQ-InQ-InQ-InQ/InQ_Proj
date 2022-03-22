package cteam.cteamproject.domain.login;

import cteam.cteamproject.domain.member.Member;
import cteam.cteamproject.domain.member.memberrepository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    //null을 리턴하면 로그인에 실패했다는 것이다.
    public Member login(String loginId, String pw) {
        return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPw().equals(pw))
                .orElse(null);
    }
}
