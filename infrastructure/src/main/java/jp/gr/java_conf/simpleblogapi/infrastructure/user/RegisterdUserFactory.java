package jp.gr.java_conf.simpleblogapi.infrastructure.user;

import jp.gr.java_conf.simpleblogapi.domain.user.RegisterdUser;
import org.springframework.stereotype.Component;

@Component
public class RegisterdUserFactory {

    public RegisterdUser from(UserEntity user) {
        return RegisterdUser.of(
                user.getId(),
                user.getPassword());
    }
}
