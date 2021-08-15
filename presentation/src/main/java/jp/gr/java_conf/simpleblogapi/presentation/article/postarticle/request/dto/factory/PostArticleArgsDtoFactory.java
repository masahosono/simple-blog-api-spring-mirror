package jp.gr.java_conf.simpleblogapi.presentation.article.postarticle.request.dto.factory;

import java.time.LocalDateTime;
import jp.gr.java_conf.simpleblogapi.application.article.dto.PostArticleArgsDto;
import jp.gr.java_conf.simpleblogapi.presentation.article.postarticle.request.PostArticleRequest;
import org.springframework.stereotype.Component;

@Component
public class PostArticleArgsDtoFactory {

    public PostArticleArgsDto create(
            PostArticleRequest request,
            LocalDateTime localDateTime) {

        return PostArticleArgsDto.of(
                request.getTitle(),
                request.getCategoryId(),
                request.getDescription(),
                request.getText(),
                localDateTime
        );
    }
}
