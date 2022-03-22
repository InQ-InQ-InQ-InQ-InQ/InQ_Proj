package cteam.cteamproject;

import cteam.cteamproject.web.converter.StateConverter;
import cteam.cteamproject.web.interceptor.LoginInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {
// 앱에서 사용하면 로그인해도 자꾸 튕기는 버그가있어서 일단 락, 대신 앱에서 처리
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor())
//                .order(1)
//                .addPathPatterns("/members/**", "/projects/**")
//                .excludePathPatterns("/members/join");
//    }
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StateConverter());
    }
}
