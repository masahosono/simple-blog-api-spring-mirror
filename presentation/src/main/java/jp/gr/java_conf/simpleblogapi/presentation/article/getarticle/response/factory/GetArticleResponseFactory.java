package jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response.factory;

import java.util.List;
import java.util.stream.Collectors;
import jp.gr.java_conf.simpleblogapi.application.article.dto.GetArticleResultDto;
import jp.gr.java_conf.simpleblogapi.domain.article.ArticleList;
import jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response.GetArticleResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response.GetArticlesResponse;
import org.springframework.stereotype.Component;

@Component
public class GetArticleResponseFactory {

    public GetArticlesResponse create(GetArticleResultDto getArticleResultDto) {
        return GetArticlesResponse.builder()
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
                                .text(article.getText())
                                .disp(article.getDisp())
                                .build())
                .collect(Collectors.collectingAndThen(Collectors.toList(), List::copyOf));
    }

}
