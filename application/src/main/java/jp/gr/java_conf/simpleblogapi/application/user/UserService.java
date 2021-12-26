package jp.gr.java_conf.simpleblogapi.application.user;

import jp.gr.java_conf.simpleblogapi.application.user.UserSignupArgsDto;
import jp.gr.java_conf.simpleblogapi.domain.user.RegisterdUser;
import jp.gr.java_conf.simpleblogapi.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    public RegisterdUser createUser(UserSignupArgsDto userSignupArgsDto) {

        String encryptedPassword = encrypt(
                userSignupArgsDto.getPassword());

        return RegisterdUser.of(
                userSignupArgsDto.getUserId(),
                encryptedPassword);
    }

    public void registerUser(RegisterdUser registerdUser) {
        userRepository.registerUser(
                registerdUser.getUserId(),
                registerdUser.getPassword());
    }

    String encrypt(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

}
