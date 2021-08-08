package jp.gr.java_conf.simpleblogapi.infrastructure.category;

import jp.gr.java_conf.simpleblogapi.domain.category.CategoryList;
import jp.gr.java_conf.simpleblogapi.domain.category.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    private final JdbcTemplate jdbcTemplate;

    public CategoryList getCategory() {
        // TODO: JDBCのコネクション
        return null;
    }

}
