package jp.gr.java_conf.simpleblogapi.presentation.category;

import jp.gr.java_conf.simpleblogapi.presentation.category.getcategory.response.GetCategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
@RequiredArgsConstructor
public class CategoryController {

    @GetMapping(path = "/api/category", produces = "application/json")
    public ResponseEntity<GetCategoryResponse> getCategory() {

        return null;
    }
}
