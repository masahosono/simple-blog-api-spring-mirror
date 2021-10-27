package jp.gr.java_conf.simpleblogapi.presentation.category.deletecategory.request.dto.factory;

import jp.gr.java_conf.simpleblogapi.application.category.dto.DeleteCategoryArgsDto;
import org.springframework.stereotype.Component;

@Component
public class DeleteCategoryArgsDtoFactory {

    public DeleteCategoryArgsDto factory(int id) {
        return DeleteCategoryArgsDto.of(id);
    }
}
