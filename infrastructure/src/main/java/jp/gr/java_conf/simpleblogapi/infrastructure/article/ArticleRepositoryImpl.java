package jp.gr.java_conf.simpleblogapi.infrastructure.article;

import java.util.List;
import jp.gr.java_conf.simpleblogapi.domain.article.ArticleList;
import jp.gr.java_conf.simpleblogapi.domain.article.ArticleRepository;
import jp.gr.java_conf.simpleblogapi.infrastructure.article.exception.ArticleDatabaseException;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ArticleRepositoryImpl implements ArticleRepository {

    private final JdbcTemplate jdbcTemplate;
    private final ArticleListFactory articleListFactory;

    public ArticleList getArticle() {

        String query = "SELECT * FROM article " +
                "WHERE disp_flg = 1" +
                "ORDER BY id DESC ";

        try {
            List<ArticleEntity> articles =
                    jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ArticleEntity.class));

            return articleListFactory.from(articles);
        } catch (RuntimeException exception) {
            throw new ArticleDatabaseException("Failed to connect the article table.");
        }
    }

    public int getArticleCount() {

        String query = "SELECT COUNT(*) AS count FROM article " +
                "WHERE disp_flg = 1";
        try {
            List<ArticleCountEntity> articlesCount =
                    jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ArticleCountEntity.class));

            return articlesCount.get(0).getCount();
        } catch (RuntimeException exception) {
            throw new ArticleDatabaseException("Failed to connect the article table.");
        }
    }

}
