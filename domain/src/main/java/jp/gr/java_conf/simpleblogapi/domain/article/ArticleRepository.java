package jp.gr.java_conf.simpleblogapi.domain.article;

import java.time.LocalDateTime;

public interface ArticleRepository {

    ArticleList getArticle();

    Article getArticleById(String id);

    int getArticleCount();

    void registerArticle(String title, int categoryId, String description, String text, LocalDateTime localDateTime);

    void editArticle(String id, String title, int categoryId, String description, String text, LocalDateTime localDateTime);

    void deleteArticle(String id);

}
