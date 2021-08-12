package jp.gr.java_conf.simpleblogapi.application.article;

import jp.gr.java_conf.simpleblogapi.application.article.dto.GetArticleResultDto;
import jp.gr.java_conf.simpleblogapi.application.category.CategoryService;
import jp.gr.java_conf.simpleblogapi.domain.article.ArticleList;
import jp.gr.java_conf.simpleblogapi.domain.article.ResolvedArticleList;
import jp.gr.java_conf.simpleblogapi.domain.category.CategoryList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetArticleService {

    private final ArticleService articleService;
    private final CategoryService categoryService;

    public GetArticleResultDto getArticle() {

        ArticleList articleList = articleService.getArticle();

        CategoryList categoryList = categoryService.getCategory();

        ResolvedArticleList resolvedArticleList =
                articleList.resolve(categoryList);

        return GetArticleResultDto.of(resolvedArticleList);
    }
}
