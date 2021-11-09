package jp.gr.java_conf.simpleblogapi.presentation.file;

import jp.gr.java_conf.simpleblogapi.presentation.file.postfile.response.PostFileResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@Component
@RequiredArgsConstructor
public class FileController {

    @PostMapping(path = "/api/file")
    public ResponseEntity<PostFileResponse> postFile(
            @RequestParam MultipartFile multipartFile) {

        return null;
    }

}
