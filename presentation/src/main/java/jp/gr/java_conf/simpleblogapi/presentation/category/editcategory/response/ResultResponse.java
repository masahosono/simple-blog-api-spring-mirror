package jp.gr.java_conf.simpleblogapi.presentation.category.editcategory.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class ResultResponse {

    @JsonProperty("category")
    private CategoryResponse category;
}
