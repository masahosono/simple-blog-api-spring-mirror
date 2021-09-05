package jp.gr.java_conf.simpleblogapi.presentation.article.deletearticle.request.dto.factory;

import jp.gr.java_conf.simpleblogapi.application.article.dto.DeleteArticleArgsDto;
import org.springframework.stereotype.Component;

@Component
public class DeleteArticleArgsDtoFactory {

    public DeleteArticleArgsDto create(
            String id) {
        return DeleteArticleArgsDto.of(id);
    }
}
