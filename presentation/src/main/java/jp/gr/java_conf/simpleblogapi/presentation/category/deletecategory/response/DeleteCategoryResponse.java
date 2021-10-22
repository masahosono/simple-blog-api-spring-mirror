package jp.gr.java_conf.simpleblogapi.presentation.category.deletecategory.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DeleteCategoryResponse {

    @JsonProperty("result")
    private ResultResponse result;

    @JsonProperty("error")
    private ErrorResponse error;
}
