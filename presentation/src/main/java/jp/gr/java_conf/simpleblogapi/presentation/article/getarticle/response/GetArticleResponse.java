package jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.Builder;

@Builder
public class GetArticleResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("categoryId")
    private int categoryId;

    @JsonProperty("createDate")
    private Date createDate;

    @JsonProperty("updateDate")
    private Date updateDate;

    @JsonProperty("text")
    private String text;

}