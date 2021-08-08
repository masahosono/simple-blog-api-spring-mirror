package jp.gr.java_conf.simpleblogapi.infrastructure.category;

import java.util.List;
import jp.gr.java_conf.simpleblogapi.domain.category.CategoryList;
import jp.gr.java_conf.simpleblogapi.domain.category.CategoryRepository;
import jp.gr.java_conf.simpleblogapi.infrastructure.category.exception.CategoryDatabaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    private final JdbcTemplate jdbcTemplate;

    private final CategoryListFactory categoryListFactory;

    public CategoryList getCategory() {
        String query = "SELECT * FROM category";

        try {
            List<CategoryEntity> categories =
                    jdbcTemplate.query(query, new BeanPropertyRowMapper<>(CategoryEntity.class));
            return categoryListFactory.from(categories);
        } catch(RuntimeException exception) {
            throw new CategoryDatabaseException("Failed to connect the category table.");
        }
    }

}
