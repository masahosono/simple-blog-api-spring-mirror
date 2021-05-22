package jp.gr.java_conf.simpleblogapi.infrastructure.article.exception;

public class ArticleNotFoundException extends RuntimeException{
    public ArticleNotFoundException(String message) {
        super(message);
    }
}
