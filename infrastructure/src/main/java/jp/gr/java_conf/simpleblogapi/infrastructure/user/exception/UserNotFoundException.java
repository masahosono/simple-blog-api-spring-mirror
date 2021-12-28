package jp.gr.java_conf.simpleblogapi.infrastructure.user.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }
}
