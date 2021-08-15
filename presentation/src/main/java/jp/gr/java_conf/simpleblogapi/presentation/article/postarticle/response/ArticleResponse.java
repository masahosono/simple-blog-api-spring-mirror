package jp.gr.java_conf.simpleblogapi.presentation.article.postarticle.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Builder;

@Builder
public class ArticleResponse {
    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("categoryId")
    private int categoryId;

    @JsonProperty("categoryName")
    private String categoryName;

    @JsonProperty("createDateTime")
    private Date createDateTIme;

    @JsonProperty("updateDateTime")
    private Date updateDateTime;

    @JsonProperty("description")
    private String description;

    @JsonProperty("text")
    private String text;
}