package jp.gr.java_conf.simpleblogapi.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class RegisterdUser {

    private final String userId;
    private final String password;

}
