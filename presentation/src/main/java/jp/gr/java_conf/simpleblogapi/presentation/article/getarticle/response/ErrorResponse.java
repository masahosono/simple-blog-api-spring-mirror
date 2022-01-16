package jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
public class ErrorResponse {

    @Getter
    @JsonIgnore
    private final HttpStatus httpStatus;

    @JsonProperty("message")
    @Schema(description = "エラーメッセージ", required = true)
    private final String message;
}
