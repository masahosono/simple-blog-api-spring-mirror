package jp.gr.java_conf.simpleblogapi.presentation.category.registercategory.request.dto.factory;

import jp.gr.java_conf.simpleblogapi.application.category.dto.RegisterCategoryArgsDto;
import jp.gr.java_conf.simpleblogapi.presentation.category.registercategory.request.RegisterCategoryRequest;
import org.springframework.stereotype.Component;

@Component
public class RegisterCategoryArgsDtoFactory {

    public RegisterCategoryArgsDto factory(RegisterCategoryRequest registerCategoryRequest) {
        return RegisterCategoryArgsDto.of(
                registerCategoryRequest.getName(),
                registerCategoryRequest.getParentId()
        );
    }
}
