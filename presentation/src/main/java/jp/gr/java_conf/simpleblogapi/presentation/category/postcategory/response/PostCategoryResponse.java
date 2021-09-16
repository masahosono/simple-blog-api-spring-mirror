package jp.gr.java_conf.simpleblogapi.presentation.category.postcategory.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostCategoryResponse {

    @JsonProperty("result")
    private ResultResponse result;

    @JsonProperty("error")
    private ErrorResponse error;
}
