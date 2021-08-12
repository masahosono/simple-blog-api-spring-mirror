package jp.gr.java_conf.simpleblogapi.domain.article;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import jp.gr.java_conf.simpleblogapi.domain.category.CategoryList;
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

    public ResolvedArticleList resolve(
            CategoryList categoryList) {

        return ResolvedArticleList.of(
                articles.stream()
                        .map(article -> ResolvedArticle.of(
                                article.getId(),
                                article.getTitle(),
                                article.getCategoryId(),
                                categoryList.getCategoryNameByCategoryId(article.getCategoryId()),
                                article.getCreateDate(),
                                article.getUpdateDate(),
                                article.getDescription(),
                                article.getText()
                        ))
                        .collect(
                                Collectors.collectingAndThen(Collectors.toList(), List::copyOf)));
    }
}
