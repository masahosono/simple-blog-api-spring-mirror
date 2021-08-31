package jp.gr.java_conf.simpleblogapi.presentation.article.editarticle.request.factory;

import jp.gr.java_conf.simpleblogapi.application.article.dto.EditArticleArgsDto;
import jp.gr.java_conf.simpleblogapi.domain.datetime.RequestedDateTime;
import jp.gr.java_conf.simpleblogapi.presentation.article.editarticle.request.EditArticleRequest;
import org.springframework.stereotype.Component;

@Component
public class EditArticleArgsDtoFactory {

    public EditArticleArgsDto create(
            String id,
            EditArticleRequest request,
            RequestedDateTime requestedDateTime) {

        return EditArticleArgsDto.of(
                id,
                request.getTitle(),
                request.getCategoryId(),
                request.getDescription(),
                request.getText(),
                requestedDateTime
        );
    }
}
