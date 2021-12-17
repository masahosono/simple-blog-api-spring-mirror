package jp.gr.java_conf.simpleblogapi.application.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class UserSignupArgsDto {

    private final String userId;
    private final String password;

}
