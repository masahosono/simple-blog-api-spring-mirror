package jp.gr.java_conf.simpleblogapi.presentation.category.editcategory.response.factory;

import jp.gr.java_conf.simpleblogapi.presentation.category.editcategory.response.ErrorResponse;
import jp.gr.java_conf.simpleblogapi.presentation.category.editcategory.response.EditCategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EditCategoryResponseEntityFactory {

    public ResponseEntity<EditCategoryResponse> create(EditCategoryResponse response) {
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
