package jp.gr.java_conf.simpleblogapi.domain.article;

public interface ArticleRepository {

    ArticleList getArticle();

    Article getArticleById(String id);

    int getArticleCount();

}
