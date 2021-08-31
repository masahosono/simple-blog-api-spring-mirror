package jp.gr.java_conf.simpleblogapi.application.article;

import jp.gr.java_conf.simpleblogapi.application.article.dto.EditArticleArgsDto;
import jp.gr.java_conf.simpleblogapi.application.article.dto.EditArticleResultDto;
import jp.gr.java_conf.simpleblogapi.application.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditArticleService {

    private final ArticleService articleService;
    private final CategoryService categoryService;

    public EditArticleResultDto editArticle(
            EditArticleArgsDto editArticleArgsDto) {

        return null;
    }
}
