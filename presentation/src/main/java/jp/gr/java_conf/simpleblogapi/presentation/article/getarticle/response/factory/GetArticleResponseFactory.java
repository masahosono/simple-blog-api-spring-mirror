package jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response.factory;

import jp.gr.java_conf.simpleblogapi.application.article.dto.GetArticleResultDto;
import jp.gr.java_conf.simpleblogapi.domain.article.ArticleList;
import jp.gr.java_conf.simpleblogapi.domain.article.ResolvedArticleList;
import jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response.ArticleResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response.ErrorResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response.GetArticleResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response.ResultResponse;
import jp.gr.java_conf.simpleblogapi.presentation.shared.HttpStatusCodeConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetArticleResponseFactory {

    private final HttpStatusCodeConverter httpStatusCodeConverter;

    public GetArticleResponse createForSuccess(GetArticleResultDto getArticleResultDto) {
        return GetArticleResponse.builder()
                .result(createResultResponse(getArticleResultDto))
                .build();
    }

    ResultResponse createResultResponse(GetArticleResultDto getArticleResultDto) {
        return ResultResponse.builder()
                .articles(createArticles(getArticleResultDto.getResolvedArticleList()))
                .build();
    }

    List<ArticleResponse> createArticles(ResolvedArticleList resolvedArticleList) {
        return resolvedArticleList.getArticles().stream()
                .map(article ->
                        ArticleResponse.builder()
                                .id(article.getId())
                                .title(article.getTitle())
                                .categoryId(article.getCategoryId())
                                .categoryName(article.getCategoryName())
                                .createDateTIme(article.getCreateDateTime())
                                .updateDateTime(article.getUpdateDateTime())
                                .description(article.getDescrition())
                                .text(article.getText())
                                .build())
                .collect(
                        Collectors.collectingAndThen(Collectors.toList(), List::copyOf));
    }

    public GetArticleResponse createForError(RuntimeException exception) {
        return GetArticleResponse.builder()
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
