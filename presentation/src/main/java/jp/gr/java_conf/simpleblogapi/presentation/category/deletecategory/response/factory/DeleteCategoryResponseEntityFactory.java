package jp.gr.java_conf.simpleblogapi.presentation.category.deletecategory.response.factory;

import jp.gr.java_conf.simpleblogapi.presentation.category.deletecategory.response.DeleteCategoryResponse;
import jp.gr.java_conf.simpleblogapi.presentation.category.deletecategory.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCategoryResponseEntityFactory {

    public ResponseEntity<DeleteCategoryResponse> create(DeleteCategoryResponse response) {
        return new ResponseEntity<>(
                response,
                resolvedHttpStatus(response.getError()));
    }

    HttpStatus resolvedHttpStatus(ErrorResponse errorResponse) {
        if (errorResponse == null) {
            return HttpStatus.OK;
        }

        // TODO: 適切なエラーステータスを指定する。
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
