package jp.gr.java_conf.simpleblogapi.application.article.dto;

import jp.gr.java_conf.simpleblogapi.domain.article.ArticleList;
import jp.gr.java_conf.simpleblogapi.domain.article.ResolvedArticleList;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class GetArticleResultDto {

    private final ResolvedArticleList resolvedArticleList;

}
