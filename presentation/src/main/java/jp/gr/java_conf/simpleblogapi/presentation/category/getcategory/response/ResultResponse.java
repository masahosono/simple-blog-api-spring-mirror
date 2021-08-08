package jp.gr.java_conf.simpleblogapi.presentation.category.getcategory.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;

@Builder
public class ResultResponse {

    @JsonProperty("categories")
    private List<CategoryResponse> categories;
}
