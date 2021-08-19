package jp.gr.java_conf.simpleblogapi.presentation.interceptor;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfigurerImpl implements WebMvcConfigurer {

    private final RequestedDateTimeHandlerMethodArgumentResolver requestedDateHandlerMethodArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolverList) {
        resolverList.add(requestedDateHandlerMethodArgumentResolver);
    }
}
