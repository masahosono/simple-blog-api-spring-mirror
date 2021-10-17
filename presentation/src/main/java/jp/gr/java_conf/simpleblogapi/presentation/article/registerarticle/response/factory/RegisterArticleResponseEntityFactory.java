package jp.gr.java_conf.simpleblogapi.presentation.article.registerarticle.response.factory;

import jp.gr.java_conf.simpleblogapi.presentation.article.registerarticle.response.ErrorResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.registerarticle.response.RegisterArticleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegisterArticleResponseEntityFactory {

    public ResponseEntity<RegisterArticleResponse> create(RegisterArticleResponse response) {
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
