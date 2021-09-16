package jp.gr.java_conf.simpleblogapi.application.category;

import jp.gr.java_conf.simpleblogapi.application.category.dto.RegisterCategoryArgsDto;
import jp.gr.java_conf.simpleblogapi.application.category.dto.RegisterCategoryResultDto;
import jp.gr.java_conf.simpleblogapi.domain.category.Category;
import jp.gr.java_conf.simpleblogapi.domain.category.ResolvedCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterCategoryService {

    private final CategoryService categoryService;

    public RegisterCategoryResultDto registerCategory(RegisterCategoryArgsDto registerCategoryArgsDto) {
        int id = categoryService.registerCategory(registerCategoryArgsDto);

        Category category = categoryService.getCategoryById(id);

        ResolvedCategory resolvedCategory = category.resolve();

        return RegisterCategoryResultDto.of(resolvedCategory);
    }
}
