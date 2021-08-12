package jp.gr.java_conf.simpleblogapi.domain.category;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class ResolvedCategoryList {

    private final List<ResolvedCategory> categoryList;

}
