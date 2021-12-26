package jp.gr.java_conf.simpleblogapi.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static jp.gr.java_conf.simpleblogapi.presentation.SecurityConstants.NO_AUTHORIZATION_REQUIRED_GET_URLS;
import static jp.gr.java_conf.simpleblogapi.presentation.SecurityConstants.NO_AUTHORIZATION_REQUIRED_POST_URLS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, NO_AUTHORIZATION_REQUIRED_GET_URLS).permitAll()
                .antMatchers(HttpMethod.POST, NO_AUTHORIZATION_REQUIRED_POST_URLS).permitAll()
                .antMatchers(HttpMethod.PUT).permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable()
                .addFilter(new JWTAuthenticationFilter(authenticationManager(), bCryptPasswordEncoder()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
