package jp.gr.java_conf.simpleblogapi.presentation.category.editcategory.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class EditCategoryRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("parentId")
    private Integer parentId;
}
