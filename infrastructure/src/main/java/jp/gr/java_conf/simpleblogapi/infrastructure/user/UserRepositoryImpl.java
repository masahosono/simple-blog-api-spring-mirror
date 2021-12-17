package jp.gr.java_conf.simpleblogapi.infrastructure.user;

import jp.gr.java_conf.simpleblogapi.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public void registerUser(
            String userId,
            String password) {

        String query = "INSERT INTO user(" +
                "id, password) " +
                "VALUES(?,?)";
        try {
            jdbcTemplate.update(
                    query,
                    userId,
                    password);
        } catch (RuntimeException exception) {
        }
    }

}
