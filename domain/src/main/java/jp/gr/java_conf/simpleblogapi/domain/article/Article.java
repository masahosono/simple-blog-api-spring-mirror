package jp.gr.java_conf.simpleblogapi.domain.article;

import java.util.Date;
import jp.gr.java_conf.simpleblogapi.domain.category.CategoryList;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class Article {

    private final String id;
    private final String title;
    private final int categoryId;
    private final Date createDateTime;
    private final Date updateDateTime;
    private final String description;
    private final String text;

    public ResolvedArticle resolve(CategoryList categoryList) {
        return ResolvedArticle.of(
                id,
                title,
                categoryId,
                categoryList.getCategoryNameByCategoryId(categoryId),
                createDateTime,
                updateDateTime,
                description,
                text);
    }
}
