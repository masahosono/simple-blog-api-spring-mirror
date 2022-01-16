package jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetArticleResponse {

    @JsonProperty("result")
    @Schema(description = "成功時のレスポンス", required = true)
    private ResultResponse result;

    @JsonProperty("error")
    @Schema(description = "エラーレスポンス", required = true)
    private ErrorResponse error;
}
