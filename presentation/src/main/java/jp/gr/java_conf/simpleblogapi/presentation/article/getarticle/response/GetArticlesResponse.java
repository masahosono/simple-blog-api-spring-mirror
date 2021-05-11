package jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Builder;

@Builder
public class GetArticlesResponse {

    @JsonProperty("articles")
    private List<GetArticleResponse> articles;
}