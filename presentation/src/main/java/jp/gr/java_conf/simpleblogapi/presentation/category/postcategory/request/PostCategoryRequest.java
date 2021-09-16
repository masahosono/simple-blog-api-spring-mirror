package jp.gr.java_conf.simpleblogapi.presentation.category.postcategory.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PostCategoryRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("parentId")
    private Integer parentId;

}
