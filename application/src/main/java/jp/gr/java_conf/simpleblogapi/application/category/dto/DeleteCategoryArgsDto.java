package jp.gr.java_conf.simpleblogapi.application.category.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class DeleteCategoryArgsDto {

    private final int id;
}
