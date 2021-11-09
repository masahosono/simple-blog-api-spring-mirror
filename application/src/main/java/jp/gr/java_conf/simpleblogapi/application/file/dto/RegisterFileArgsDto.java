package jp.gr.java_conf.simpleblogapi.application.file.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class RegisterFileArgsDto {

    private final MultipartFile multipartFile;
    private final LocalDateTime localDateTime;

}
