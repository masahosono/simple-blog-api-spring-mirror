package jp.gr.java_conf.simpleblogapi.presentation.article.editarticle.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class ResultResponse {

    @JsonProperty("article")
    private ArticleResponse article;

}
