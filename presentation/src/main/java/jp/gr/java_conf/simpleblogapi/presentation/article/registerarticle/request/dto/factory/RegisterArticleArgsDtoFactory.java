package jp.gr.java_conf.simpleblogapi.presentation.article.registerarticle.request.dto.factory;

import jp.gr.java_conf.simpleblogapi.application.article.dto.RegisterArticleArgsDto;
import jp.gr.java_conf.simpleblogapi.domain.datetime.RequestedDateTime;
import jp.gr.java_conf.simpleblogapi.presentation.article.registerarticle.request.RegisterArticleRequest;
import org.springframework.stereotype.Component;

@Component
public class RegisterArticleArgsDtoFactory {

    public RegisterArticleArgsDto create(
            RegisterArticleRequest request,
            RequestedDateTime requestedDateTime) {

        return RegisterArticleArgsDto.of(
                request.getTitle(),
                request.getCategoryId(),
                request.getDescription(),
                request.getText(),
                requestedDateTime
        );
    }
}
