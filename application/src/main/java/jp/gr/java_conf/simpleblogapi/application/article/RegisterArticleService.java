package jp.gr.java_conf.simpleblogapi.application.article;

import jp.gr.java_conf.simpleblogapi.application.article.dto.RegisterArticleArgsDto;
import jp.gr.java_conf.simpleblogapi.application.article.dto.RegisterArticleResultDto;
import jp.gr.java_conf.simpleblogapi.application.category.CategoryService;
import jp.gr.java_conf.simpleblogapi.domain.article.Article;
import jp.gr.java_conf.simpleblogapi.domain.article.ResolvedArticle;
import jp.gr.java_conf.simpleblogapi.domain.category.CategoryList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterArticleService {

    private final ArticleService articleService;
    private final CategoryService categoryService;

    public RegisterArticleResultDto registerArticle(
            RegisterArticleArgsDto registerArticleArgsDto) {

        articleService.registerArticle(registerArticleArgsDto);

        Article article = articleService.getArticleById(
                registerArticleArgsDto.getRequestedDateTime().format());

        CategoryList categoryList = categoryService.getCategory();

        ResolvedArticle resolvedArticle = article.resolve(categoryList);

        return RegisterArticleResultDto.of(resolvedArticle);
    }
}
