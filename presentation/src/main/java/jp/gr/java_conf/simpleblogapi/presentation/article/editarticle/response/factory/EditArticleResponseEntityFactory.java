package jp.gr.java_conf.simpleblogapi.presentation.article.editarticle.response.factory;

import jp.gr.java_conf.simpleblogapi.presentation.article.editarticle.response.EditArticleResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.editarticle.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EditArticleResponseEntityFactory {

    public ResponseEntity<EditArticleResponse> create(EditArticleResponse response) {
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
