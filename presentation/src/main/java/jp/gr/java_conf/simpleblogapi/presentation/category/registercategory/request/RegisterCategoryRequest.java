package jp.gr.java_conf.simpleblogapi.presentation.category.registercategory.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class RegisterCategoryRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("parentId")
    private Integer parentId;

}
