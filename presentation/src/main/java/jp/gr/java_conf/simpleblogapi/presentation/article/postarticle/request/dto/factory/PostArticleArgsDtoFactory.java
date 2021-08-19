package jp.gr.java_conf.simpleblogapi.presentation.article.postarticle.request.dto.factory;

import jp.gr.java_conf.simpleblogapi.application.article.dto.PostArticleArgsDto;
import jp.gr.java_conf.simpleblogapi.domain.datetime.RequestedDateTime;
import jp.gr.java_conf.simpleblogapi.presentation.article.postarticle.request.PostArticleRequest;
import org.springframework.stereotype.Component;

@Component
public class PostArticleArgsDtoFactory {

    public PostArticleArgsDto create(
            PostArticleRequest request,
            RequestedDateTime requestedDateTime) {

        return PostArticleArgsDto.of(
                request.getTitle(),
                request.getCategoryId(),
                request.getDescription(),
                request.getText(),
                requestedDateTime
        );
    }
}
