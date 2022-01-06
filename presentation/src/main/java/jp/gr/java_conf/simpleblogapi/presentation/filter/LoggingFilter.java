package jp.gr.java_conf.simpleblogapi.presentation.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
public class LoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull FilterChain filterChain) throws IOException, ServletException {
        StopWatch time = new StopWatch();
        time.start();

        log.info("API start. Method:{}, URI:{}",
                request.getMethod(),
                request.getRequestURI());

        try {
            filterChain.doFilter(request, response);
        } catch (ServletException | IOException exception) {
            log.error("FilterChain Error. Method:{}, URI:{}, message:{}",
                    request.getMethod(),
                    request.getRequestURI(),
                    exception.getMessage(),
                    exception);
            throw exception;
        } finally {
            time.stop();
            log.info("API end. Method:{}, URI:{}, Status code:{}, Time:{}",
                    request.getMethod(),
                    request.getRequestURI(),
                    response.getStatus(),
                    time.getLastTaskInfo().getTimeMillis());
        }
    }
}
