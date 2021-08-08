package jp.gr.java_conf.simpleblogapi.application.category;

import jp.gr.java_conf.simpleblogapi.application.article.ArticleService;
import jp.gr.java_conf.simpleblogapi.application.category.dto.GetCategoriesResultDto;
import jp.gr.java_conf.simpleblogapi.domain.article.ArticleList;
import jp.gr.java_conf.simpleblogapi.domain.category.CategoryList;
import jp.gr.java_conf.simpleblogapi.domain.category.ResolvedCategoryList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GetCategoryService {

    private final ArticleService articleService;
    private final CategoryService categoryService;

    public GetCategoriesResultDto getCategory() {
        CategoryList categoryList = categoryService.getCategory();
        ArticleList articleList = articleService.getArticle();

        ResolvedCategoryList resolvedCategoryList =
                categoryList.resolve(articleList);

        return GetCategoriesResultDto.of(resolvedCategoryList);
    }
}
