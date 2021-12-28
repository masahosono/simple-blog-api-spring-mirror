package jp.gr.java_conf.simpleblogapi.infrastructure.user.exception;

public class UserDatabaseException extends RuntimeException{

    public UserDatabaseException(String message) {
        super(message);
    }
}
