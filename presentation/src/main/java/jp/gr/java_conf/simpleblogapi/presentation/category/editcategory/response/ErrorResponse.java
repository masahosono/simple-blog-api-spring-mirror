package jp.gr.java_conf.simpleblogapi.presentation.category.editcategory.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public class ErrorResponse {

    @NotNull
    @JsonProperty("message")
    private final String message;
}
