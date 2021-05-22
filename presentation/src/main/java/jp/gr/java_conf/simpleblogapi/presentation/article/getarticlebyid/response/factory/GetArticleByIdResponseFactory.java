package jp.gr.java_conf.simpleblogapi.presentation.article.getarticlebyid.response.factory;

import jp.gr.java_conf.simpleblogapi.application.article.dto.GetArticleByIdResultDto;
import jp.gr.java_conf.simpleblogapi.domain.article.Article;
import jp.gr.java_conf.simpleblogapi.presentation.article.getarticlebyid.response.ArticleResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.getarticlebyid.response.ErrorResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.getarticlebyid.response.GetArticleByIdResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.getarticlebyid.response.ResultResponse;
import jp.gr.java_conf.simpleblogapi.presentation.shared.HttpStatusCodeConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class GetArticleByIdResponseFactory {

    private final HttpStatusCodeConverter httpStatusCodeConverter;

    public GetArticleByIdResponse createForSuccess(GetArticleByIdResultDto getArticleByIdResultDto) {
        return GetArticleByIdResponse.builder()
                .result(createResultResponse(getArticleByIdResultDto.getArticle()))
                .build();
    }

    ResultResponse createResultResponse(Article article) {
        return ResultResponse.builder()
                .article(createArticle(article))
                .build();
    }

    ArticleResponse createArticle(Article article) {
        return ArticleResponse.builder()
                .id(article.getId())
                .title(article.getTitle())
                .categoryId(article.getCategoryId())
                .createDateTIme(article.getCreateDate())
                .updateDateTime(article.getCreateDate())
                .text(article.getText())
                .build();
    }

    public GetArticleByIdResponse createForError(RuntimeException exception) {
        return GetArticleByIdResponse.builder()
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
