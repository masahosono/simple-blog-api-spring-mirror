package jp.gr.java_conf.simpleblogapi.presentation.article.deletearticle.response.factory;

import jp.gr.java_conf.simpleblogapi.presentation.article.deletearticle.response.DeleteArticleResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.deletearticle.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteArticleResponseEntityFactory {

    public ResponseEntity<DeleteArticleResponse> create(DeleteArticleResponse response) {
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
