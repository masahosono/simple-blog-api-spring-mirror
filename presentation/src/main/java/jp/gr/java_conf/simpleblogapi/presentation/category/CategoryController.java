package jp.gr.java_conf.simpleblogapi.presentation.category;

import jp.gr.java_conf.simpleblogapi.application.category.GetCategoryService;
import jp.gr.java_conf.simpleblogapi.application.category.dto.GetCategoriesResultDto;
import jp.gr.java_conf.simpleblogapi.presentation.category.getcategory.response.GetCategoryResponse;
import jp.gr.java_conf.simpleblogapi.presentation.category.getcategory.response.factory.GetCategoryResponseEntityFactory;
import jp.gr.java_conf.simpleblogapi.presentation.category.getcategory.response.factory.GetCategoryResponseFactory;
import jp.gr.java_conf.simpleblogapi.presentation.category.postcategory.request.PostCategoryRequest;
import jp.gr.java_conf.simpleblogapi.presentation.category.postcategory.response.PostCategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
@RequiredArgsConstructor
public class CategoryController {

    private final GetCategoryService getCategoryService;
    private final GetCategoryResponseFactory getCategoryResponseFactory;
    private final GetCategoryResponseEntityFactory getCategoryResponseEntityFactory;

    @GetMapping(path = "/api/category", produces = "application/json")
    public ResponseEntity<GetCategoryResponse> getCategory() {

        GetCategoryResponse response;
        try {
            GetCategoriesResultDto getCategoriesResultDto =
                    getCategoryService.getCategory();
            response = getCategoryResponseFactory.createForSuccess(getCategoriesResultDto);
        } catch (RuntimeException exception) {
            response = getCategoryResponseFactory.createForError(exception);
        }

        return getCategoryResponseEntityFactory.create(response);
    }

    @PostMapping(path = "/api/category", produces = "application/json")
    public ResponseEntity<PostCategoryResponse> postCategory(
            @RequestBody PostCategoryRequest requestBody) {

        return null;
    }
}
