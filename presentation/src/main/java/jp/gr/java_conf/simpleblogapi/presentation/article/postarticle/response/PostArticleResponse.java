package jp.gr.java_conf.simpleblogapi.presentation.article.postarticle.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Builder;

@Builder
public class PostArticleResponse {

    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("categoryId")
    private String categoryId;

    @JsonProperty("createDate")
    private Date createDate;

    @JsonProperty("updateDate")
    private Date updateDate;

    @JsonProperty("text")
    private String text;

    @JsonProperty("disp")
    private int disp;
}