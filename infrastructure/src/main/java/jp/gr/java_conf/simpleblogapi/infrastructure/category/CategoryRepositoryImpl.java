package jp.gr.java_conf.simpleblogapi.infrastructure.category;

import java.util.List;
import jp.gr.java_conf.simpleblogapi.domain.category.Category;
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
    private final CategoryFactory categoryFactory;

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

    public Category getCategoryById(int id) {
        String query = "SELECT * FROM category WHERE id = ?";

        try {
            CategoryEntity category =
                    jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(CategoryEntity.class), id);
            return categoryFactory.from(category);
        } catch(RuntimeException exception) {
            throw new CategoryDatabaseException("Failed to connect the category table.");
        }
    }

    public int registerCategory(String name, Integer parentId) {
        String query = "INSERT INTO " +
                "category(name, parent_id) " +
                "VALUES(?,?)";

        try {
            jdbcTemplate.update(
                    query,
                    name,
                    parentId);
            return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        } catch (RuntimeException exception) { // TODO: SQLIntegrityConstraintViolationExceptionをキャッチしたい
            throw new CategoryDatabaseException("Failed to connect the category table.");
        }
    }

}
