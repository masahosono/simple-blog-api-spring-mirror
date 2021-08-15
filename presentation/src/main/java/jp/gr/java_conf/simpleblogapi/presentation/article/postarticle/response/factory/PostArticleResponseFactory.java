package jp.gr.java_conf.simpleblogapi.presentation.article.postarticle.response.factory;

import jp.gr.java_conf.simpleblogapi.application.article.dto.PostArticleResultDto;
import jp.gr.java_conf.simpleblogapi.domain.article.ResolvedArticle;
import jp.gr.java_conf.simpleblogapi.presentation.article.postarticle.response.ArticleResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.postarticle.response.ErrorResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.postarticle.response.PostArticleResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.postarticle.response.ResultResponse;
import jp.gr.java_conf.simpleblogapi.presentation.shared.HttpStatusCodeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostArticleResponseFactory {

    private final HttpStatusCodeConverter httpStatusCodeConverter;

    public PostArticleResponse createForSuccess(PostArticleResultDto postArticleResultDto) {
        return PostArticleResponse.builder()
                .result(createResultResponse(postArticleResultDto.getResolvedArticle()))
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

    public PostArticleResponse createForError(RuntimeException exception) {
        return PostArticleResponse.builder()
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
