package jp.gr.java_conf.simpleblogapi.application.category;

import jp.gr.java_conf.simpleblogapi.application.category.dto.EditCategoryArgsDto;
import jp.gr.java_conf.simpleblogapi.application.category.dto.EditCategoryResultDto;
import jp.gr.java_conf.simpleblogapi.domain.category.Category;
import jp.gr.java_conf.simpleblogapi.domain.category.ResolvedCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EditCategoryService {

    private final CategoryService categoryService;

    public EditCategoryResultDto editCategory(EditCategoryArgsDto editCategoryArgsDto) {
        categoryService.editCategory(editCategoryArgsDto);

        Category category = categoryService.getCategoryById(editCategoryArgsDto.getId());

        ResolvedCategory resolvedCategory = category.resolve();

        return EditCategoryResultDto.of(resolvedCategory);
    }
}
