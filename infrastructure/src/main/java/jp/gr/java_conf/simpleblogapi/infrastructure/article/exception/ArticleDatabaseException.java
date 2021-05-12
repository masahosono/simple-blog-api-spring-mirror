package jp.gr.java_conf.simpleblogapi.infrastructure.article.exception;

public class ArticleDatabaseException extends RuntimeException{

    public ArticleDatabaseException(String message) {
        super(message);
    }
}
