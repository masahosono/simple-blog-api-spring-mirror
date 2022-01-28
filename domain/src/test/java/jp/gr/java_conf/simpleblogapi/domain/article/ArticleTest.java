package jp.gr.java_conf.simpleblogapi.domain.article;

import java.sql.Date;
import jp.gr.java_conf.simpleblogapi.domain.category.CategoryList;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ArticleTest {

    @Test
    void resolve_ResolvedArticleが生成されること() {
        // given
        CategoryList categoryListMock = mock(CategoryList.class);
        when(categoryListMock.getCategoryNameByCategoryId(1)).thenReturn("categoryName");

        Date dateMock1 = mock(Date.class);
        Date dateMock2 = mock(Date.class);

        Article target = Article.of(
                "id",
                "title",
                1,
                dateMock1,
                dateMock2,
                "description",
                "text"
        );

        ResolvedArticle expected =
                ResolvedArticle.of(
                        "id",
                        "title",
                        1,
                        "categoryName",
                        dateMock1,
                        dateMock2,
                        "description",
                        "text");

        // when
        ResolvedArticle actual = target.resolve(categoryListMock);

        // then
        assertThat(actual)
                .usingRecursiveComparison()
                .withStrictTypeChecking()
                .isEqualTo(expected);
    }

}