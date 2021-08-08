package jp.gr.java_conf.simpleblogapi.domain.category;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class ResolvedCategoryList {

    private final List<ResolvedCategory> categoryList;

    public List<ResolvedCategory> getCategoriesByParentId(int categoryId) {
        return categoryList.stream()
                .filter(category -> !StringUtils.isEmpty(category.getParentId()) && category.getParentId() == categoryId)
                .collect(Collectors.collectingAndThen(Collectors.toList(), List::copyOf));
    }

}
