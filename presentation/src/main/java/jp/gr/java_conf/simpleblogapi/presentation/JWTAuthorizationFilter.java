package jp.gr.java_conf.simpleblogapi.presentation;

import io.jsonwebtoken.Jwts;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static jp.gr.java_conf.simpleblogapi.presentation.SecurityConstants.SECRET;

@Slf4j
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAuthorizationFilter(
            AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest req,
            HttpServletResponse res,
            FilterChain chain) throws IOException, ServletException {

        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            onUnsuccessfulAuthentication(req, res, null);
            chain.doFilter(req, res);
            return;
        }

        String jwtValue = Arrays.stream(cookies)
                .filter(cookie -> cookie.getName().equals("_j"))
                .findFirst()
                .map(Cookie::getValue)
                .orElse(null);

        if (jwtValue == null) {
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(jwtValue);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String jwtValue) {
        String user = Jwts.parser()
                .setSigningKey(SECRET.getBytes())
                .parseClaimsJws(jwtValue)
                .getBody()
                .getSubject();

        if (user != null) {
            return new UsernamePasswordAuthenticationToken(
                    user,
                    null,
                    new ArrayList<>());
        }
        return null;
    }
}
