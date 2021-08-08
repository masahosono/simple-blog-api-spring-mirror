package jp.gr.java_conf.simpleblogapi.presentation.category.getcategory.response.factory;

import java.util.List;
import java.util.stream.Collectors;
import jp.gr.java_conf.simpleblogapi.application.category.dto.GetCategoriesResultDto;
import jp.gr.java_conf.simpleblogapi.domain.category.ResolvedCategoryList;
import jp.gr.java_conf.simpleblogapi.presentation.category.getcategory.response.CategoryResponse;
import jp.gr.java_conf.simpleblogapi.presentation.category.getcategory.response.ErrorResponse;
import jp.gr.java_conf.simpleblogapi.presentation.category.getcategory.response.GetCategoryResponse;
import jp.gr.java_conf.simpleblogapi.presentation.category.getcategory.response.ResultResponse;
import org.springframework.stereotype.Component;

@Component
public class GetCategoryResponseFactory {

    public GetCategoryResponse createForSuccess(GetCategoriesResultDto getCategoriesResultDto) {
        return GetCategoryResponse.builder()
                .result(createResult(getCategoriesResultDto.getResolvedCategoryList()))
                .build();
    }

    ResultResponse createResult(ResolvedCategoryList resolvedCategoryList) {
        return ResultResponse.builder()
                .categories(createCategories(resolvedCategoryList))
                .build();
    }

    List<CategoryResponse> createCategories(ResolvedCategoryList resolvedCategoryList) {
        return resolvedCategoryList.getCategoryList().stream()
                .map(category ->
                        CategoryResponse.builder()
                                .id(category.getId())
                                .name(category.getName())
                                .articleNumber(category.getArticleNumber())
                                .parentId(category.getParentId())
                                .build())
                .collect(Collectors.collectingAndThen(Collectors.toList(), List::copyOf));
    }

    public GetCategoryResponse createForError(RuntimeException exception) {
        return GetCategoryResponse.builder()
                .error(createError(exception))
                .build();
    }

    public ErrorResponse createError(RuntimeException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }
}
