package jp.gr.java_conf.simpleblogapi.presentation.category.deletecategory.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class ErrorResponse {

    @JsonProperty("message")
    private final String message;
}
