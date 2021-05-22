package jp.gr.java_conf.simpleblogapi.presentation.article.getarticlebyid.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetArticleByIdResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("categoryId")
    private int categoryId;

    @JsonProperty("createDateTime")
    private Date createDateTIme;

    @JsonProperty("updateDateTime")
    private Date updateDateTime;

    @JsonProperty("description")
    private String description;

    @JsonProperty("text")
    private String text;

}
