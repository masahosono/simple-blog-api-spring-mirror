package jp.gr.java_conf.simpleblogapi.presentation.article.editarticle.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class EdtArticleRequest {

    @JsonProperty("title")
    private String title;

    @JsonProperty("categoryId")
    private String categoryId;

    @JsonProperty("text")
    private String text;

}