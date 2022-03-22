package cteam.cteamproject.web;

import lombok.Getter;

@Getter
public class Success {

    private final Boolean success;

    public Success(Boolean success) {
        this.success = success;
    }
}
