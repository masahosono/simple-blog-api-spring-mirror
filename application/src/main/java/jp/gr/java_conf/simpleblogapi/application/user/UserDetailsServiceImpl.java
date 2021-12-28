package jp.gr.java_conf.simpleblogapi.application.user;

import jp.gr.java_conf.simpleblogapi.domain.user.RegisterdUser;
import jp.gr.java_conf.simpleblogapi.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        RegisterdUser registerdUser = userRepository.getUser(userId);

        return User.withUsername(userId)
                .password(registerdUser.getPassword())
                .authorities("ROLE_ADMIN")
                .build();
    }
}