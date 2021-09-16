package jp.gr.java_conf.simpleblogapi.application.category.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class RegisterCategoryArgsDto {

    private final String name;
    private final Integer parentId;
}
