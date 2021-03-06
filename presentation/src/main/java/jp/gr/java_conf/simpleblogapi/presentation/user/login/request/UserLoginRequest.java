package jp.gr.java_conf.simpleblogapi.presentation.user.login.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UserLoginRequest {

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("password")
    private String password;
}
