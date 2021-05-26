package jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response.factory;

import java.util.List;
import java.util.stream.Collectors;
import jp.gr.java_conf.simpleblogapi.application.article.dto.GetArticleResultDto;
import jp.gr.java_conf.simpleblogapi.domain.article.ArticleList;
import jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response.GetArticleResponse;
import org.springframework.stereotype.Component;

@Component
public class GetArticleResponseFactory {

    public GetArticleResponse create(GetArticleResultDto getArticleResultDto) {
        return GetArticleResponse.builder()
                .articles(createArticles(getArticleResultDto.getArticleList()))
                .build();
    }

    List<GetArticleResponse> createArticles(ArticleList articleList) {
        return articleList.getArticles().stream()
                .map(article ->
                        GetArticleResponse.builder()
                                .id(article.getId())
                                .title(article.getTitle())
                                .categoryId(article.getCategoryId())
                                .createDate(article.getCreateDate())
                                .updateDate(article.getUpdateDate())
                                .description(article.getDescription())
                                .text(article.getText())
                                .build())
                .collect(Collectors.collectingAndThen(Collectors.toList(), List::copyOf));
    }

}
