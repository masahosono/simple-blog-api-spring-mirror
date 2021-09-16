package jp.gr.java_conf.simpleblogapi.presentation.category.postcategory.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class CategoryResponse {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("parentId")
    private Integer parentId;
}
