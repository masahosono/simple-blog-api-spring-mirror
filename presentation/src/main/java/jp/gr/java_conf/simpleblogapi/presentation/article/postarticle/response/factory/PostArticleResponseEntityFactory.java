package jp.gr.java_conf.simpleblogapi.presentation.article.postarticle.response.factory;

import jp.gr.java_conf.simpleblogapi.presentation.article.postarticle.response.ErrorResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.postarticle.response.PostArticleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostArticleResponseEntityFactory {

    public ResponseEntity<PostArticleResponse> create(PostArticleResponse response) {
        return new ResponseEntity<>(
                response,
                resolvedHttpStatus(response.getError()));
    }

    HttpStatus resolvedHttpStatus(ErrorResponse errorResponse) {
        if (errorResponse == null) {
            return HttpStatus.OK;
        }

        return errorResponse.getHttpStatus();
    }
}
