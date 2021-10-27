package jp.gr.java_conf.simpleblogapi.presentation.category.deletecategory.response.factory;

import jp.gr.java_conf.simpleblogapi.presentation.category.deletecategory.response.DeleteCategoryResponse;
import jp.gr.java_conf.simpleblogapi.presentation.category.deletecategory.response.ErrorResponse;
import jp.gr.java_conf.simpleblogapi.presentation.category.deletecategory.response.ResultResponse;
import org.springframework.stereotype.Component;

@Component
public class DeleteCategoryResponseFactory {

    public DeleteCategoryResponse createForSuccess() {
        return DeleteCategoryResponse.builder()
                .result(createResultResponse())
                .build();
    }

    public ResultResponse createResultResponse() {
        return ResultResponse.builder()
                .success(true)
                .build();
    }

    public DeleteCategoryResponse createForError(RuntimeException exception) {
        return DeleteCategoryResponse.builder()
                .error(createError(exception))
                .build();
    }

    ErrorResponse createError(RuntimeException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }
}
