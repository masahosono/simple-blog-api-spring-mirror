package jp.gr.java_conf.simpleblogapi.domain.article;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class ResolvedArticleList {

    private final List<ResolvedArticle> articles;

}
