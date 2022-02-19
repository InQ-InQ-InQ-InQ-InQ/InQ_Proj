package InQ.projectmanager;

import lombok.Getter;

@Getter
public class Success {

    private final Boolean success;

    public Success(Boolean success) {
        this.success = success;
    }
}
