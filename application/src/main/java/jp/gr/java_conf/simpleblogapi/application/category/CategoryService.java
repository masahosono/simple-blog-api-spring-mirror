package jp.gr.java_conf.simpleblogapi.application.category;

import jp.gr.java_conf.simpleblogapi.domain.category.CategoryList;
import jp.gr.java_conf.simpleblogapi.domain.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryList getCategory() {
        CategoryList categoryList = categoryRepository.getCategory();
        return categoryList;
    }
}
