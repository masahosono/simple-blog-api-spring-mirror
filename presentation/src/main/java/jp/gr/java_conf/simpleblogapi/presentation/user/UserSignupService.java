package jp.gr.java_conf.simpleblogapi.presentation.user;

import jp.gr.java_conf.simpleblogapi.application.user.UserSignupArgsDto;
import jp.gr.java_conf.simpleblogapi.domain.user.RegisterdUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSignupService {

    private final UserService userService;

    public void signup(UserSignupArgsDto userSignupArgsDto) {

        RegisterdUser registerdUser = userService.createUser(userSignupArgsDto);
        userService.registerUser(registerdUser);
    }
}
