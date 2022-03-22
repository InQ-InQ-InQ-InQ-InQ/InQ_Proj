package cteam.cteamproject.web.converter;

import cteam.cteamproject.domain.project.PjStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class StateConverter implements Converter<String, PjStatus> {

    @Override
    public PjStatus convert(String source) {

        log.info("컨버터 실행 source={}", source);
        switch (source) {
            case "ING":
                return PjStatus.ING;
            case "FIN":
                return PjStatus.FIN;
            case "RECRUIT":
                return PjStatus.RECRUIT;
        }
        return PjStatus.RECRUIT;
    }
}
