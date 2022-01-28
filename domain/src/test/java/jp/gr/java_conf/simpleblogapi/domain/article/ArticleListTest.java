package jp.gr.java_conf.simpleblogapi.domain.article;

import java.util.Date;
import java.util.List;
import jp.gr.java_conf.simpleblogapi.domain.category.CategoryList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ArticleListTest {

    @ParameterizedTest
    @CsvSource({
            "1, 2",
            "2, 0"
    })
    void getArticleCountByCategoryId_指定されたカテゴリIDに紐づく記事数が取得できること(
            int categoryId,
            int expected) {
        // given
        Article articleMock1 = mock(Article.class);
        when(articleMock1.getCategoryId()).thenReturn(1);

        Article articleMock2 = mock(Article.class);
        when(articleMock2.getCategoryId()).thenReturn(1);
        ArticleList target =
                ArticleList.of(
                        List.of(articleMock1, articleMock2));

        // when
        int actual = target.getArticleCountByCategoryId(categoryId);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void resolve_ResolvedArticleListが生成されること() {
        // given
        Article articleMock1 = mock(Article.class);
        when(articleMock1.getId()).thenReturn("id1");
        when(articleMock1.getTitle()).thenReturn("title1");
        when(articleMock1.getCategoryId()).thenReturn(1);
        Date createDateTimeMock1 = mock(Date.class);
        when(articleMock1.getCreateDateTime()).thenReturn(createDateTimeMock1);
        Date updateDateTimeMock1 = mock(Date.class);
        when(articleMock1.getUpdateDateTime()).thenReturn(updateDateTimeMock1);
        when(articleMock1.getDescription()).thenReturn("description1");
        when(articleMock1.getText()).thenReturn("text1");

        Article articleMock2 = mock(Article.class);
        when(articleMock2.getId()).thenReturn("id2");
        when(articleMock2.getTitle()).thenReturn("title2");
        when(articleMock2.getCategoryId()).thenReturn(2);
        Date createDateTimeMock2 = mock(Date.class);
        when(articleMock2.getCreateDateTime()).thenReturn(createDateTimeMock2);
        Date updateDateTimeMock2 = mock(Date.class);
        when(articleMock2.getUpdateDateTime()).thenReturn(updateDateTimeMock2);
        when(articleMock2.getDescription()).thenReturn("description2");
        when(articleMock2.getText()).thenReturn("text2");

        CategoryList categoryListMock = mock(CategoryList.class);
        when(categoryListMock.getCategoryNameByCategoryId(1)).thenReturn("categoryName1");
        when(categoryListMock.getCategoryNameByCategoryId(2)).thenReturn("categoryName2");

        ArticleList target =
                ArticleList.of(
                        List.of(articleMock1, articleMock2));

        ResolvedArticleList expected =
                ResolvedArticleList.of(
                        List.of(
                                ResolvedArticle.of(
                                        "id1",
                                        "title1",
                                        1,
                                        "categoryName1",
                                        createDateTimeMock1,
                                        updateDateTimeMock1,
                                        "description1",
                                        "text1"
                                ),
                                ResolvedArticle.of(
                                        "id2",
                                        "title2",
                                        2,
                                        "categoryName2",
                                        createDateTimeMock2,
                                        updateDateTimeMock2,
                                        "description2",
                                        "text2"
                                )
                        )
                );

        // when
        ResolvedArticleList actual = target.resolve(categoryListMock);

        // then
        assertThat(actual)
                .usingRecursiveComparison()
                .withStrictTypeChecking()
                .isEqualTo(expected);
    }

}