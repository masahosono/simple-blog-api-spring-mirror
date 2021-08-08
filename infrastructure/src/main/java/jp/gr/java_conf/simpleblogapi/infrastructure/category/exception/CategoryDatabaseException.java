package jp.gr.java_conf.simpleblogapi.infrastructure.category.exception;

public class CategoryDatabaseException extends RuntimeException{
    public CategoryDatabaseException(String message) {
        super(message);
    }
}
