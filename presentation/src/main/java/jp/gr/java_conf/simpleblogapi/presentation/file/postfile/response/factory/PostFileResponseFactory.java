package jp.gr.java_conf.simpleblogapi.presentation.file.postfile.response.factory;

import jp.gr.java_conf.simpleblogapi.application.file.dto.RegisterFileResultDto;
import jp.gr.java_conf.simpleblogapi.presentation.file.postfile.response.PostFileResponse;
import org.springframework.stereotype.Component;

@Component
public class PostFileResponseFactory {

    public PostFileResponse create(RegisterFileResultDto registerFileResultDto) {
        return PostFileResponse.builder()
                .fileName(registerFileResultDto.getFileName())
                .build();
    }
}
