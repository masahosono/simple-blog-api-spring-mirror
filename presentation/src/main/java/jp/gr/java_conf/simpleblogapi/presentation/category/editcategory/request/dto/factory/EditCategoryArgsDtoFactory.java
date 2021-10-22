package jp.gr.java_conf.simpleblogapi.presentation.category.editcategory.request.dto.factory;

import jp.gr.java_conf.simpleblogapi.application.category.dto.EditCategoryArgsDto;
import jp.gr.java_conf.simpleblogapi.presentation.category.editcategory.request.EditCategoryRequest;
import org.springframework.stereotype.Component;

@Component
public class EditCategoryArgsDtoFactory {

    public EditCategoryArgsDto factory(EditCategoryRequest editCategoryRequest, int id) {
        return EditCategoryArgsDto.of(
                id,
                editCategoryRequest.getName(),
                editCategoryRequest.getParentId()
        );
    }
}
