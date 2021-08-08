package jp.gr.java_conf.simpleblogapi.infrastructure.category;

import java.util.List;
import java.util.stream.Collectors;
import jp.gr.java_conf.simpleblogapi.domain.category.CategoryList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CategoryListFactory {

    private final CategoryFactory categoryFactory;

    public CategoryList from(List<CategoryEntity> categoryEntities) {
        return CategoryList.of(categoryEntities.stream()
                .map(categoryFactory::from)
                .collect(Collectors.collectingAndThen(Collectors.toList(), List::copyOf)));
    }
}
