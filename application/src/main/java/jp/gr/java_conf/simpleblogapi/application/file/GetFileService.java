package jp.gr.java_conf.simpleblogapi.application.file;

import jp.gr.java_conf.simpleblogapi.application.file.dto.GetFileResultDto;
import jp.gr.java_conf.simpleblogapi.domain.file.File;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetFileService {

    private final FileService fileService;

    public GetFileResultDto getFile(String fileName) {
        File file = fileService.getFile(fileName);

        return GetFileResultDto.of(
                file.getFile(),
                file.getFileType());
    }
}
