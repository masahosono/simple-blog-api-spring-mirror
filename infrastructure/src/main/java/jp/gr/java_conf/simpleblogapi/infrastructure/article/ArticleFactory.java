package jp.gr.java_conf.simpleblogapi.infrastructure.article;

import jp.gr.java_conf.simpleblogapi.domain.article.Article;
import org.springframework.stereotype.Component;

@Component
public class ArticleFactory {

    public Article from(ArticleEntity articleEntity) {
        return Article.of(
            articleEntity.getId(),
            articleEntity.getTitle(),
            articleEntity.getCategory_id(),
            articleEntity.getCreate_date_time(),
            articleEntity.getUpdate_date_time(),
            articleEntity.getDescription(),
            articleEntity.getText());
    }
}
