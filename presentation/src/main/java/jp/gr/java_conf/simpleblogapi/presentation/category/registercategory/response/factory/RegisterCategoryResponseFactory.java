package jp.gr.java_conf.simpleblogapi.presentation.category.registercategory.response.factory;

import jp.gr.java_conf.simpleblogapi.application.category.dto.RegisterCategoryResultDto;
import jp.gr.java_conf.simpleblogapi.domain.category.ResolvedCategory;
import jp.gr.java_conf.simpleblogapi.presentation.category.registercategory.response.CategoryResponse;
import jp.gr.java_conf.simpleblogapi.presentation.category.registercategory.response.ErrorResponse;
import jp.gr.java_conf.simpleblogapi.presentation.category.registercategory.response.RegisterCategoryResponse;
import jp.gr.java_conf.simpleblogapi.presentation.category.registercategory.response.ResultResponse;
import org.springframework.stereotype.Component;

@Component
public class RegisterCategoryResponseFactory {

    public RegisterCategoryResponse createForSuccess(RegisterCategoryResultDto registerCategoryResultDto) {
        return RegisterCategoryResponse.builder()
                .result(createResultResponse(registerCategoryResultDto.getCategory()))
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

    public RegisterCategoryResponse createForError(RuntimeException exception) {
        return RegisterCategoryResponse.builder()
                .error(createError(exception))
                .build();
    }

    ErrorResponse createError(RuntimeException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }
}
