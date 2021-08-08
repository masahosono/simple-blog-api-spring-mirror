package jp.gr.java_conf.simpleblogapi.application.category.dto;

import jp.gr.java_conf.simpleblogapi.domain.category.ResolvedCategoryList;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class GetCategoriesResultDto {

    private final ResolvedCategoryList resolvedCategoryList;

}
