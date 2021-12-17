package jp.gr.java_conf.simpleblogapi.presentation.user.signup.request.factory;

import jp.gr.java_conf.simpleblogapi.application.user.UserSignupArgsDto;
import jp.gr.java_conf.simpleblogapi.presentation.user.signup.request.UserSignupRequest;
import org.springframework.stereotype.Component;

@Component
public class UserSignupArgsDtoFactory {

    public UserSignupArgsDto factory(UserSignupRequest userSignupRequest) {
        return UserSignupArgsDto.of(
                userSignupRequest.getUserId(),
                userSignupRequest.getPassword());
    }
}
