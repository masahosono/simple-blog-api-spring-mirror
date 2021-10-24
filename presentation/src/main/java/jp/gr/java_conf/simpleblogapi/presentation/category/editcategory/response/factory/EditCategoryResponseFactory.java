package jp.gr.java_conf.simpleblogapi.presentation.category.editcategory.response.factory;

import jp.gr.java_conf.simpleblogapi.application.category.dto.EditCategoryResultDto;
import jp.gr.java_conf.simpleblogapi.domain.category.ResolvedCategory;
import jp.gr.java_conf.simpleblogapi.presentation.category.editcategory.response.CategoryResponse;
import jp.gr.java_conf.simpleblogapi.presentation.category.editcategory.response.EditCategoryResponse;
import jp.gr.java_conf.simpleblogapi.presentation.category.editcategory.response.ErrorResponse;
import jp.gr.java_conf.simpleblogapi.presentation.category.editcategory.response.ResultResponse;
import org.springframework.stereotype.Component;

@Component
public class EditCategoryResponseFactory {

    public EditCategoryResponse createForSuccess(EditCategoryResultDto editCategoryResultDto) {
        return EditCategoryResponse.builder()
                .result(createResultResponse(editCategoryResultDto.getCategory()))
                .build();
    }

    public ResultResponse createResultResponse(ResolvedCategory resolvedCategory) {
        return ResultResponse.builder()
                .category(createCategoryResponse(resolvedCategory))
                .build();
    }

    public CategoryResponse createCategoryResponse(ResolvedCategory resolvedCategory) {
        return CategoryResponse.builder()
                .id(resolvedCategory.getId())
                .name(resolvedCategory.getName())
                .parentId(resolvedCategory.getParentId())
                .build();
    }

    public EditCategoryResponse createForError(RuntimeException exception) {
        return EditCategoryResponse.builder()
                .error(createError(exception))
                .build();
    }

    ErrorResponse createError(RuntimeException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }
}
