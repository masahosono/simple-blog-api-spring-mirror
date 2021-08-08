package jp.gr.java_conf.simpleblogapi.infrastructure.category;

import jp.gr.java_conf.simpleblogapi.domain.category.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryFactory {

    public Category from(CategoryEntity categoryEntity) {
        return Category.of(
                categoryEntity.getId(),
                categoryEntity.getName(),
                categoryEntity.getParent_id());
    }
}
