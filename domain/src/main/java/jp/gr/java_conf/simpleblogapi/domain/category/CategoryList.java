package jp.gr.java_conf.simpleblogapi.domain.category;

import java.util.List;
import java.util.stream.Collectors;
import jp.gr.java_conf.simpleblogapi.domain.article.ArticleList;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class CategoryList {

    private final List<Category> categoryList;

    public ResolvedCategoryList resolve(ArticleList articleList) {
        return ResolvedCategoryList.of(categoryList.stream()
                .map(category -> ResolvedCategory.of(
                        category.getId(),
                        category.getName(),
                        articleList.getArticleCountByCategoryId(category.getId()),
                        category.getParentId()))
                .collect(
                        Collectors.collectingAndThen(Collectors.toList(), List::copyOf)));
    }
}
