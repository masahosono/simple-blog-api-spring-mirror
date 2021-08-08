package jp.gr.java_conf.simpleblogapi.domain.article;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class ArticleList {

    private final List<Article> articles;

    public int getArticleCountByCategoryId(int categoryId) {
        return (int) articles.stream()
                .filter(article -> article.getCategoryId() == categoryId)
                .count();
    }
}
