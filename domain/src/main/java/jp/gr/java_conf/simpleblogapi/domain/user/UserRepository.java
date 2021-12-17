package jp.gr.java_conf.simpleblogapi.domain.user;

public interface UserRepository {

    void registerUser(
            String userId,
            String password);
}
