package jp.gr.java_conf.simpleblogapi.application.category;

import jp.gr.java_conf.simpleblogapi.application.category.dto.DeleteCategoryArgsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteCategoryService {

    private final CategoryService categoryService;

    public void deleteCategory(DeleteCategoryArgsDto deleteCategoryArgsDto) {
        // TODO: Delete成功時のレコード情報を返す
        categoryService.deleteCategory(deleteCategoryArgsDto);
    }
}
