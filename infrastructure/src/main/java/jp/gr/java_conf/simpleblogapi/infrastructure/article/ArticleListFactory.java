package jp.gr.java_conf.simpleblogapi.infrastructure.article;

import java.util.List;
import java.util.stream.Collectors;
import jp.gr.java_conf.simpleblogapi.domain.article.Article;
import jp.gr.java_conf.simpleblogapi.domain.article.ArticleList;
import org.springframework.stereotype.Component;

@Component
public class ArticleListFactory {

    public ArticleList from(List<ArticleEntity> articleEntities) {
        return ArticleList.of(articleEntities.stream()
                .map(articleEntity ->
                        Article.of(
                                articleEntity.getId(),
                                articleEntity.getTitle(),
                                articleEntity.getCategory_id(),
                                articleEntity.getCreate_date_time(),
                                articleEntity.getUpdate_date_time(),
                                articleEntity.getDescription(),
                                articleEntity.getText()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), List::copyOf)));
    }
}
