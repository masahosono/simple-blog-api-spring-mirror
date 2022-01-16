package jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.Builder;

@Builder
public class ResultResponse {

    @Schema(description = "記事リスト")
    @JsonProperty("articles")
    private List<ArticleResponse> articles;

}
