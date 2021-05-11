package jp.gr.java_conf.simpleblogapi.infrastructure.article;

import jp.gr.java_conf.simpleblogapi.domain.article.ArticleList;
import jp.gr.java_conf.simpleblogapi.domain.article.ArticleRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {

    public ArticleList getArticle() {
        // TODO: JDBC
        return null;
    }

}
