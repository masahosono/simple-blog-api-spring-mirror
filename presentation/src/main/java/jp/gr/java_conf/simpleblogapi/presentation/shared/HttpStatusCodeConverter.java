package jp.gr.java_conf.simpleblogapi.presentation.shared;

import jp.gr.java_conf.simpleblogapi.infrastructure.article.exception.ArticleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class HttpStatusCodeConverter {

    public HttpStatus from(RuntimeException exception) {

        if (exception instanceof ArticleNotFoundException) {
            return HttpStatus.NOT_FOUND;
        }

        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
