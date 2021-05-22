package jp.gr.java_conf.simpleblogapi.presentation.article.getarticlebyid.response.factory;

import jp.gr.java_conf.simpleblogapi.application.article.dto.GetArticleByIdResultDto;
import jp.gr.java_conf.simpleblogapi.domain.article.Article;
import jp.gr.java_conf.simpleblogapi.presentation.article.getarticlebyid.response.GetArticleByIdResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class GetArticleByIdResponseFactory {

    public GetArticleByIdResponse create(GetArticleByIdResultDto getArticleByIdResultDto) {

        Article article = getArticleByIdResultDto.getArticle();
//        return GetArticleByIdResponse.builder()
//                .id(article.getId())
//                .title(article.getTitle())
//                .categoryId(article.getCategoryId())
//                .createDateTIme(article.getCreateDate())
//                .updateDateTime(article.getUpdateDate())
//                .text(article.getText())
//                .build();
        return null;
    }

}
