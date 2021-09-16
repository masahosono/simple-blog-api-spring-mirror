package jp.gr.java_conf.simpleblogapi.presentation.category.postcategory.request.dto.factory;

import jp.gr.java_conf.simpleblogapi.application.category.dto.RegisterCategoryArgsDto;
import jp.gr.java_conf.simpleblogapi.presentation.category.postcategory.request.PostCategoryRequest;
import org.springframework.stereotype.Component;

@Component
public class RegisterCategoryArgsDtoFactory {

    public RegisterCategoryArgsDto factory(PostCategoryRequest postCategoryRequest) {
        return RegisterCategoryArgsDto.of(
                postCategoryRequest.getName(),
                postCategoryRequest.getParentId()
        );
    }
}
