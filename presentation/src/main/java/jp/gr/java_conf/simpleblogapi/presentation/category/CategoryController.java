package jp.gr.java_conf.simpleblogapi.presentation.category;

import jp.gr.java_conf.simpleblogapi.application.category.DeleteCategoryService;
import jp.gr.java_conf.simpleblogapi.application.category.EditCategoryService;
import jp.gr.java_conf.simpleblogapi.application.category.GetCategoryService;
import jp.gr.java_conf.simpleblogapi.application.category.RegisterCategoryService;
import jp.gr.java_conf.simpleblogapi.application.category.dto.DeleteCategoryArgsDto;
import jp.gr.java_conf.simpleblogapi.application.category.dto.EditCategoryArgsDto;
import jp.gr.java_conf.simpleblogapi.application.category.dto.EditCategoryResultDto;
import jp.gr.java_conf.simpleblogapi.application.category.dto.GetCategoriesResultDto;
import jp.gr.java_conf.simpleblogapi.application.category.dto.RegisterCategoryArgsDto;
import jp.gr.java_conf.simpleblogapi.application.category.dto.RegisterCategoryResultDto;
import jp.gr.java_conf.simpleblogapi.presentation.category.deletecategory.request.dto.factory.DeleteCategoryArgsDtoFactory;
import jp.gr.java_conf.simpleblogapi.presentation.category.deletecategory.response.DeleteCategoryResponse;
import jp.gr.java_conf.simpleblogapi.presentation.category.deletecategory.response.factory.DeleteCategoryResponseEntityFactory;
import jp.gr.java_conf.simpleblogapi.presentation.category.deletecategory.response.factory.DeleteCategoryResponseFactory;
import jp.gr.java_conf.simpleblogapi.presentation.category.editcategory.request.EditCategoryRequest;
import jp.gr.java_conf.simpleblogapi.presentation.category.editcategory.request.dto.factory.EditCategoryArgsDtoFactory;
import jp.gr.java_conf.simpleblogapi.presentation.category.editcategory.response.EditCategoryResponse;
import jp.gr.java_conf.simpleblogapi.presentation.category.editcategory.response.factory.EditCategoryResponseEntityFactory;
import jp.gr.java_conf.simpleblogapi.presentation.category.editcategory.response.factory.EditCategoryResponseFactory;
import jp.gr.java_conf.simpleblogapi.presentation.category.getcategory.response.GetCategoryResponse;
import jp.gr.java_conf.simpleblogapi.presentation.category.getcategory.response.factory.GetCategoryResponseEntityFactory;
import jp.gr.java_conf.simpleblogapi.presentation.category.getcategory.response.factory.GetCategoryResponseFactory;
import jp.gr.java_conf.simpleblogapi.presentation.category.registercategory.request.RegisterCategoryRequest;
import jp.gr.java_conf.simpleblogapi.presentation.category.registercategory.request.dto.factory.RegisterCategoryArgsDtoFactory;
import jp.gr.java_conf.simpleblogapi.presentation.category.registercategory.response.RegisterCategoryResponse;
import jp.gr.java_conf.simpleblogapi.presentation.category.registercategory.response.factory.RegisterCategoryResponseEntityFactory;
import jp.gr.java_conf.simpleblogapi.presentation.category.registercategory.response.factory.RegisterCategoryResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    private final RegisterCategoryResponseFactory registerCategoryResponseFactory;
    private final RegisterCategoryResponseEntityFactory registerCategoryResponseEntityFactory;

    private final EditCategoryService editCategoryService;
    private final EditCategoryArgsDtoFactory editCategoryArgsDtoFactory;
    private final EditCategoryResponseFactory editCategoryResponseFactory;
    private final EditCategoryResponseEntityFactory editCategoryResponseEntityFactory;

    private final DeleteCategoryService deleteCategoryService;
    private final DeleteCategoryArgsDtoFactory deleteCategoryArgsDtoFactory;
    private final DeleteCategoryResponseFactory deleteCategoryResponseFactory;
    private final DeleteCategoryResponseEntityFactory deleteCategoryResponseEntityFactory;

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
    public ResponseEntity<RegisterCategoryResponse> registerCategory(
            @RequestBody RegisterCategoryRequest requestBody) {

        RegisterCategoryResponse response;
        try {
            RegisterCategoryArgsDto registerCategoryArgsDto =
                    registerCategoryArgsDtoFactory.factory(requestBody);

            RegisterCategoryResultDto registerCategoryResultDto
                    = registerCategoryService.registerCategory(registerCategoryArgsDto);

            response = registerCategoryResponseFactory.createForSuccess(registerCategoryResultDto);
        } catch (RuntimeException exception) {
            response = registerCategoryResponseFactory.createForError(exception);
        }

        return registerCategoryResponseEntityFactory.create(response);
    }

    @PutMapping(path = "/api/category/{id}", produces = "application/json")
    public ResponseEntity<EditCategoryResponse> editCategory(
            @RequestBody EditCategoryRequest requestBody,
            @PathVariable("id") int id) {

        EditCategoryResponse response;
        try {
            EditCategoryArgsDto editCategoryArgsDto =
                    editCategoryArgsDtoFactory.factory(requestBody, id);

            EditCategoryResultDto editCategoryResultDto =
                    editCategoryService.editCategory(editCategoryArgsDto);

            response = editCategoryResponseFactory.createForSuccess(editCategoryResultDto);
        } catch (RuntimeException exception) {
            response = editCategoryResponseFactory.createForError(exception);
        }

        return editCategoryResponseEntityFactory.create(response);
    }

    @DeleteMapping(path = "/api/category/{id}", produces = "application/json")
    public ResponseEntity<DeleteCategoryResponse> deleteCategory(
            @PathVariable("id") int id) {

        DeleteCategoryResponse response;
        try {
            DeleteCategoryArgsDto deleteCategoryArgsDto =
                    deleteCategoryArgsDtoFactory.factory(id);

            deleteCategoryService.deleteCategory(deleteCategoryArgsDto);

            response = deleteCategoryResponseFactory.createForSuccess();
        } catch (RuntimeException exception) {
            response = deleteCategoryResponseFactory.createForError(exception);
        }

        return deleteCategoryResponseEntityFactory.create(response);
    }
}
