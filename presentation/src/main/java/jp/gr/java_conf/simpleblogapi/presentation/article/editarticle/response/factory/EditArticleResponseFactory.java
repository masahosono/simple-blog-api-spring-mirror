package jp.gr.java_conf.simpleblogapi.presentation.article.editarticle.response.factory;

import jp.gr.java_conf.simpleblogapi.application.article.dto.EditArticleResultDto;
import jp.gr.java_conf.simpleblogapi.domain.article.ResolvedArticle;
import jp.gr.java_conf.simpleblogapi.presentation.article.editarticle.response.ArticleResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.editarticle.response.EditArticleResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.editarticle.response.ErrorResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.editarticle.response.ResultResponse;
import jp.gr.java_conf.simpleblogapi.presentation.shared.HttpStatusCodeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EditArticleResponseFactory {

    private final HttpStatusCodeConverter httpStatusCodeConverter;

    public EditArticleResponse createForSuccess(EditArticleResultDto editArticleResultDto) {
        return EditArticleResponse.builder()
                .result(createResultResponse(editArticleResultDto.getResolvedArticle()))
                .build();
    }

    ResultResponse createResultResponse(ResolvedArticle resolvedArticle) {
        return ResultResponse.builder()
                .article(createArticle(resolvedArticle))
                .build();
    }

    ArticleResponse createArticle(ResolvedArticle resolvedArticle) {
        return ArticleResponse.builder()
                .id(resolvedArticle.getId())
                .title(resolvedArticle.getTitle())
                .categoryId(resolvedArticle.getCategoryId())
                .categoryName(resolvedArticle.getCategoryName())
                .createDateTIme(resolvedArticle.getCreateDateTime())
                .updateDateTime(resolvedArticle.getUpdateDateTime())
                .description(resolvedArticle.getDescription())
                .text(resolvedArticle.getText())
                .build();
    }

    public EditArticleResponse createForError(RuntimeException exception) {
        return EditArticleResponse.builder()
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
