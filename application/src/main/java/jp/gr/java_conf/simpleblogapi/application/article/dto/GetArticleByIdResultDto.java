package jp.gr.java_conf.simpleblogapi.application.article.dto;

import jp.gr.java_conf.simpleblogapi.domain.article.Article;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class GetArticleByIdResultDto {

    private final Article article;

}
