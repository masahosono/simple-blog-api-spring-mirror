package jp.gr.java_conf.simpleblogapi.application.article.dto;

import jp.gr.java_conf.simpleblogapi.domain.article.ResolvedArticle;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class PostArticleResultDto {

    private final ResolvedArticle resolvedArticle;

}
