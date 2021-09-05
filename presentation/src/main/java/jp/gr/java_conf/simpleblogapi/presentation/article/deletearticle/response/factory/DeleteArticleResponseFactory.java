package jp.gr.java_conf.simpleblogapi.presentation.article.deletearticle.response.factory;

import jp.gr.java_conf.simpleblogapi.presentation.article.deletearticle.response.DeleteArticleResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.deletearticle.response.ErrorResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.deletearticle.response.ResultResponse;
import jp.gr.java_conf.simpleblogapi.presentation.shared.HttpStatusCodeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteArticleResponseFactory {

    private final HttpStatusCodeConverter httpStatusCodeConverter;

    public DeleteArticleResponse createForSuccess() {
        return DeleteArticleResponse.builder()
                .result(createResultResponse())
                .build();
    }

    ResultResponse createResultResponse() {
        return ResultResponse.builder()
                .success(true)
                .build();
    }

    public DeleteArticleResponse createForError(RuntimeException exception) {
        return DeleteArticleResponse.builder()
                .error(createError(exception))
                .build();
    }

    ErrorResponse createError(RuntimeException exception) {
        return ErrorResponse.builder()
                .httpStatus(httpStatusCodeConverter.from(exception))
                .message(exception.getMessage())
                .build();
    }

}
