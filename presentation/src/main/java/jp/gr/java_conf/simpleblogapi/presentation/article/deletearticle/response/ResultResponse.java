package jp.gr.java_conf.simpleblogapi.presentation.article.deletearticle.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class ResultResponse {

    @JsonProperty("success")
    private boolean success;
}
