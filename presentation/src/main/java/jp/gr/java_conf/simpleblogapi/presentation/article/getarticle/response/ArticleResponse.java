package jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import lombok.Builder;

@Builder
public class ArticleResponse {

    @JsonProperty("id")
    @Schema(description = "記事ID", required = true)
    private String id;

    @JsonProperty("title")
    @Schema(description = "記事タイトル", required = true)
    private String title;

    @JsonProperty("categoryId")
    @Schema(description = "カテゴリID", required = true)
    private Integer categoryId;

    @JsonProperty("categoryName")
    @Schema(description = "カテゴリ名", required = true)
    private String categoryName;

    @JsonProperty("createDateTime")
    @Schema(description = "作成日時", required = true)
    private Date createDateTIme;

    @JsonProperty("updateDateTime")
    @Schema(description = "更新日時", required = true)
    private Date updateDateTime;

    @JsonProperty("description")
    @Schema(description = "記事概要説明", required = true)
    private String description;

    @JsonProperty("text")
    @Schema(description = "記事本文", required = true)
    private String text;
}