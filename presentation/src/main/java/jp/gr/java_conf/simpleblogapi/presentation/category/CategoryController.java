package jp.gr.java_conf.simpleblogapi.presentation.category;

import jp.gr.java_conf.simpleblogapi.application.category.GetCategoryService;
import jp.gr.java_conf.simpleblogapi.application.category.RegisterCategoryService;
import jp.gr.java_conf.simpleblogapi.application.category.dto.GetCategoriesResultDto;
import jp.gr.java_conf.simpleblogapi.application.category.dto.RegisterCategoryArgsDto;
import jp.gr.java_conf.simpleblogapi.application.category.dto.RegisterCategoryResultDto;
import jp.gr.java_conf.simpleblogapi.presentation.category.getcategory.response.GetCategoryResponse;
import jp.gr.java_conf.simpleblogapi.presentation.category.getcategory.response.factory.GetCategoryResponseEntityFactory;
import jp.gr.java_conf.simpleblogapi.presentation.category.getcategory.response.factory.GetCategoryResponseFactory;
import jp.gr.java_conf.simpleblogapi.presentation.category.postcategory.request.PostCategoryRequest;
import jp.gr.java_conf.simpleblogapi.presentation.category.postcategory.request.dto.factory.RegisterCategoryArgsDtoFactory;
import jp.gr.java_conf.simpleblogapi.presentation.category.postcategory.response.PostCategoryResponse;
import jp.gr.java_conf.simpleblogapi.presentation.category.postcategory.response.factory.PostCategoryResponseEntityFactory;
import jp.gr.java_conf.simpleblogapi.presentation.category.postcategory.response.factory.PostCategoryResponseFactory;
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

    private final RegisterCategoryService registerCategoryService;
    private final RegisterCategoryArgsDtoFactory registerCategoryArgsDtoFactory;
    private final PostCategoryResponseFactory postCategoryResponseFactory;
    private final PostCategoryResponseEntityFactory postCategoryResponseEntityFactory;

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

        PostCategoryResponse response;
        try {
            RegisterCategoryArgsDto registerCategoryArgsDto =
                    registerCategoryArgsDtoFactory.factory(requestBody);

            RegisterCategoryResultDto registerCategoryResultDto
                    = registerCategoryService.registerCategory(registerCategoryArgsDto);

            response = postCategoryResponseFactory.createForSuccess(registerCategoryResultDto);
        } catch (RuntimeException exception) {
            response = postCategoryResponseFactory.createForError(exception);
        }

        return postCategoryResponseEntityFactory.create(response);
    }
}
