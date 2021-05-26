package jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetArticleResponse {

    @JsonProperty("result")
    private ResultResponse result;

    @JsonProperty("error")
    private ErrorResponse error;
}
