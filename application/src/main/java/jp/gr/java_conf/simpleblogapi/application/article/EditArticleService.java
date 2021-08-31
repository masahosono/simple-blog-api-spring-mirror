package jp.gr.java_conf.simpleblogapi.application.article;

import jp.gr.java_conf.simpleblogapi.application.article.dto.EditArticleArgsDto;
import jp.gr.java_conf.simpleblogapi.application.article.dto.EditArticleResultDto;
import jp.gr.java_conf.simpleblogapi.application.category.CategoryService;
import jp.gr.java_conf.simpleblogapi.domain.article.Article;
import jp.gr.java_conf.simpleblogapi.domain.article.ResolvedArticle;
import jp.gr.java_conf.simpleblogapi.domain.category.CategoryList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditArticleService {

    private final ArticleService articleService;
    private final CategoryService categoryService;

    public EditArticleResultDto editArticle(
            EditArticleArgsDto editArticleArgsDto) {

        articleService.editArticle(editArticleArgsDto);

        Article article = articleService.getArticleById(editArticleArgsDto.getId());

        CategoryList categoryList = categoryService.getCategory();
        ResolvedArticle resolvedArticle = article.resolve(categoryList);

        return EditArticleResultDto.of(resolvedArticle);
    }
}
