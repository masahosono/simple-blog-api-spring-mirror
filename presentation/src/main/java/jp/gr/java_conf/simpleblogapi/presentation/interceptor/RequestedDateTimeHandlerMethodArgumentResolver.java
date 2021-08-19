package jp.gr.java_conf.simpleblogapi.presentation.interceptor;

import java.time.Clock;
import jp.gr.java_conf.simpleblogapi.domain.datetime.RequestedDateTime;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class RequestedDateTimeHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private final Clock clock;

    public RequestedDateTimeHandlerMethodArgumentResolver(Clock clock) {
        this.clock = clock;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(RequestedDateTime.class);
    }

    @Override
    public RequestedDateTime resolveArgument(
            MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory) {
        return RequestedDateTime.nowWith(clock);
    }
}
