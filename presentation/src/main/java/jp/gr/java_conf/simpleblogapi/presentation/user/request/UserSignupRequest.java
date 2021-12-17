package jp.gr.java_conf.simpleblogapi.presentation.user.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UserSignupRequest {

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("password")
    private String password;

}
