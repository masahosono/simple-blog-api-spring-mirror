package jp.gr.java_conf.simpleblogapi.presentation.user;

import jp.gr.java_conf.simpleblogapi.application.user.UserSignupArgsDto;
import jp.gr.java_conf.simpleblogapi.presentation.user.signup.request.UserSignupRequest;
import jp.gr.java_conf.simpleblogapi.presentation.user.signup.request.factory.UserSignupArgsDtoFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
@RequiredArgsConstructor
public class UserController {

    private final UserSignupService userSignupService;
    private final UserSignupArgsDtoFactory userSignupArgsDtoFactory;

    @GetMapping(value = "/api/user/auth", produces = "application/json")
    public void auth() {
        // TODO: 処理を記載
    }

    @PostMapping(value = "/api/user/signup", produces = "application/json")
    public void signup(
            @RequestBody UserSignupRequest requestBody) {
        UserSignupArgsDto userSignupArgsDto =
                userSignupArgsDtoFactory.factory(requestBody);

        userSignupService.signup(userSignupArgsDto);
    }
}
