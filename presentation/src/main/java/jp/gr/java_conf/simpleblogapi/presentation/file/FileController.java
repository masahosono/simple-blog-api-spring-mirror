package jp.gr.java_conf.simpleblogapi.presentation.file;

import java.time.LocalDateTime;
import jp.gr.java_conf.simpleblogapi.application.file.FileUploadService;
import jp.gr.java_conf.simpleblogapi.application.file.dto.GetFileResultDto;
import jp.gr.java_conf.simpleblogapi.application.file.dto.RegisterFileArgsDto;
import jp.gr.java_conf.simpleblogapi.application.file.dto.RegisterFileResultDto;
import jp.gr.java_conf.simpleblogapi.presentation.file.postfile.request.dto.factory.RegisterFileArgsDtoFactory;
import jp.gr.java_conf.simpleblogapi.presentation.file.postfile.response.PostFileResponse;
import jp.gr.java_conf.simpleblogapi.presentation.file.postfile.response.factory.PostFileResponseEntityFactory;
import jp.gr.java_conf.simpleblogapi.presentation.file.postfile.response.factory.PostFileResponseFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@Component
@RequiredArgsConstructor
public class FileController {

    private final FileUploadService fileUploadService;
    private final RegisterFileArgsDtoFactory registerFileArgsDtoFactory;
    private final PostFileResponseEntityFactory postFileResponseEntityFactory;
    private final PostFileResponseFactory postFileResponseFactory;

    @PostMapping(path = "/api/file")
    public ResponseEntity<PostFileResponse> postFile(
            @RequestParam MultipartFile multipartFile) {

        LocalDateTime localDateTime = LocalDateTime.now();

        log.info("ContentType:　"  +  multipartFile.getContentType());
        log.info("OriginalFileName: " + multipartFile.getOriginalFilename());
        log.info("Size: " + String.valueOf(multipartFile.getSize()));

        RegisterFileArgsDto registerFileArgsDto =
                registerFileArgsDtoFactory.factory(multipartFile, localDateTime);

        RegisterFileResultDto registerFileResultDto =
                fileUploadService.registerFile(registerFileArgsDto);

        return postFileResponseEntityFactory.create(
                postFileResponseFactory.create(registerFileResultDto));
    }

    @GetMapping(path = "/file/{fileName}")
    public ResponseEntity<byte[]> getFile(
            @PathVariable("fileName") String fileName) {
        return null;
    }

}
