package cteam.cteamproject.web.exception;

import lombok.Getter;

import java.util.List;

@Getter
public class ErrorResult {

    private final Boolean success;
    private final String code;
    private final List<String> messages;

    public ErrorResult(String code, List<String> messages) {
        this.success = false;
        this.code = code;
        this.messages = messages;
    }
}
