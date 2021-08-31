package jp.gr.java_conf.simpleblogapi.application.article.dto;

import jp.gr.java_conf.simpleblogapi.domain.article.ResolvedArticle;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class EditArticleResultDto {

    private final ResolvedArticle resolvedArticle;

}
