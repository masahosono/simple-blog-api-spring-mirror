package jp.gr.java_conf.simpleblogapi.application.category;

import jp.gr.java_conf.simpleblogapi.application.category.dto.EditCategoryArgsDto;
import jp.gr.java_conf.simpleblogapi.application.category.dto.RegisterCategoryArgsDto;
import jp.gr.java_conf.simpleblogapi.domain.category.Category;
import jp.gr.java_conf.simpleblogapi.domain.category.CategoryList;
import jp.gr.java_conf.simpleblogapi.domain.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryList getCategory() {
        return categoryRepository.getCategory();
    }

    public Category getCategoryById(int id) {
        return categoryRepository.getCategoryById(id);
    }

    public int registerCategory(RegisterCategoryArgsDto registerCategoryArgsDto) {
        return categoryRepository.registerCategory(
                registerCategoryArgsDto.getName(),
                registerCategoryArgsDto.getParentId());
    }

    void editCategory(EditCategoryArgsDto editCategoryArgsDto) {
        categoryRepository.editCategory(
                editCategoryArgsDto.getId(),
                editCategoryArgsDto.getName(),
                editCategoryArgsDto.getParentId());
    }

}
