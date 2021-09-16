package jp.gr.java_conf.simpleblogapi.presentation.category.postcategory.response.factory;

import jp.gr.java_conf.simpleblogapi.application.category.dto.RegisterCategoryResultDto;
import jp.gr.java_conf.simpleblogapi.domain.category.ResolvedCategory;
import jp.gr.java_conf.simpleblogapi.presentation.category.postcategory.response.CategoryResponse;
import jp.gr.java_conf.simpleblogapi.presentation.category.postcategory.response.ErrorResponse;
import jp.gr.java_conf.simpleblogapi.presentation.category.postcategory.response.PostCategoryResponse;
import jp.gr.java_conf.simpleblogapi.presentation.category.postcategory.response.ResultResponse;
import org.springframework.stereotype.Component;

@Component
public class PostCategoryResponseFactory {

    public PostCategoryResponse createForSuccess(RegisterCategoryResultDto registerCategoryResultDto) {
        return PostCategoryResponse.builder()
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

    public PostCategoryResponse createForError(RuntimeException exception) {
        return PostCategoryResponse.builder()
                .error(createError(exception))
                .build();
    }

    ErrorResponse createError(RuntimeException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }
}
