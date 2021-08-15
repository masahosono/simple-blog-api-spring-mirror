package jp.gr.java_conf.simpleblogapi.presentation.article.postarticle.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PostArticleRequest {

    @JsonProperty("title")
    private String title;

    @JsonProperty("categoryId")
    private int categoryId;

    @JsonProperty("description")
    private String description;

    @JsonProperty("text")
    private String text;

}