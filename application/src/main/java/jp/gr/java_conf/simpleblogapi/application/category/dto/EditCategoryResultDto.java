package jp.gr.java_conf.simpleblogapi.application.category.dto;

import jp.gr.java_conf.simpleblogapi.domain.category.ResolvedCategory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class EditCategoryResultDto {

    private final ResolvedCategory category;

}
