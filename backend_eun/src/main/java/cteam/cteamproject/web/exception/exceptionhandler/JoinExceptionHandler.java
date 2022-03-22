package cteam.cteamproject.web.exception.exceptionhandler;

import cteam.cteamproject.web.exception.ErrorResult;
import cteam.cteamproject.web.login.controller.LoginController;
import cteam.cteamproject.web.member.controller.MemberController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@ResponseStatus(HttpStatus.BAD_REQUEST)
@RestControllerAdvice(assignableTypes = {MemberController.class, LoginController.class})
@RequiredArgsConstructor
public class JoinExceptionHandler {

    private final MessageSource ms;

    @ExceptionHandler(BindException.class)
    public ErrorResult validException(org.springframework.validation.BindException e) {
        log.error("exception ex", e);
        List<String> messages = e.getAllErrors().stream()
                .map(ex -> ex.getDefaultMessage())
//                .map(ex -> ms.getMessage(ex.getCode(), null, null))
                .collect(Collectors.toList());

        return new ErrorResult("BAD_REQUEST", messages);
    }
}
