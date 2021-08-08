package jp.gr.java_conf.simpleblogapi.presentation.category.getcategory.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;

@Builder
public class CategoryResponse {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("articleNumber")
    private long articleNumber;

    @JsonProperty("parentId")
    private Integer parentId;
}
