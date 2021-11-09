package jp.gr.java_conf.simpleblogapi.presentation.file.postfile.request.dto.factory;

import java.time.LocalDateTime;
import jp.gr.java_conf.simpleblogapi.application.file.dto.RegisterFileArgsDto;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class RegisterFileArgsDtoFactory {

    public RegisterFileArgsDto factory(
            MultipartFile multipartFile,
            LocalDateTime localDateTime) {
        return RegisterFileArgsDto.of(
                multipartFile, localDateTime);
    }
}
