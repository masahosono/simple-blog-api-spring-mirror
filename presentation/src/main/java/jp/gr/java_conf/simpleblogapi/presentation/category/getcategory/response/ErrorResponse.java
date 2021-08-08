package jp.gr.java_conf.simpleblogapi.presentation.category.getcategory.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class ErrorResponse {

    @JsonProperty("message")
    private final String message;
}
