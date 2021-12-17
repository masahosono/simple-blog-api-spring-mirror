package jp.gr.java_conf.simpleblogapi.presentation.user;

import jp.gr.java_conf.simpleblogapi.presentation.user.request.UserSignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
@RequiredArgsConstructor
public class UserController {

    @PostMapping(value = "/api/user/signup", produces = "application/json")
    public void signup(
            @RequestBody UserSignupRequest requestBody) {
    }
}
