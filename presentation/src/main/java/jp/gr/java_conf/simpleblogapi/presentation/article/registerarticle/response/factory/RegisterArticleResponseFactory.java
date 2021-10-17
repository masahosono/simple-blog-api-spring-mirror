package jp.gr.java_conf.simpleblogapi.presentation.article.registerarticle.response.factory;

import jp.gr.java_conf.simpleblogapi.application.article.dto.RegisterArticleResultDto;
import jp.gr.java_conf.simpleblogapi.domain.article.ResolvedArticle;
import jp.gr.java_conf.simpleblogapi.presentation.article.registerarticle.response.ArticleResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.registerarticle.response.ErrorResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.registerarticle.response.RegisterArticleResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.registerarticle.response.ResultResponse;
import jp.gr.java_conf.simpleblogapi.presentation.shared.HttpStatusCodeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterArticleResponseFactory {

    private final HttpStatusCodeConverter httpStatusCodeConverter;

    public RegisterArticleResponse createForSuccess(RegisterArticleResultDto registerArticleResultDto) {
        return RegisterArticleResponse.builder()
                .result(createResultResponse(registerArticleResultDto.getResolvedArticle()))
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

    public RegisterArticleResponse createForError(RuntimeException exception) {
        return RegisterArticleResponse.builder()
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
