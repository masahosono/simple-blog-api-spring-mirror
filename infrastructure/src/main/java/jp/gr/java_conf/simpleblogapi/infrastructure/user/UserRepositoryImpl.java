package jp.gr.java_conf.simpleblogapi.infrastructure.user;

import jp.gr.java_conf.simpleblogapi.domain.user.RegisterdUser;
import jp.gr.java_conf.simpleblogapi.domain.user.UserRepository;
import jp.gr.java_conf.simpleblogapi.infrastructure.user.exception.UserDatabaseException;
import jp.gr.java_conf.simpleblogapi.infrastructure.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RegisterdUserFactory registerdUserFactory;

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

    public RegisterdUser getUser(String userId) {
        String query = "SELECT * FROM user WHERE id = ?";

        try {
            UserEntity user =
                    jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(UserEntity.class), userId);
            return registerdUserFactory.from(user);
        } catch (EmptyResultDataAccessException emptyResultDataAccessException) {
            throw new UserNotFoundException("User not found");
        } catch(RuntimeException exception) {
            throw new UserDatabaseException("Failed to connect the user table.");
        }
    }

}
