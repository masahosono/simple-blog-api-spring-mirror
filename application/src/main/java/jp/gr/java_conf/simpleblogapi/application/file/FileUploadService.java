package jp.gr.java_conf.simpleblogapi.application.file;

import jp.gr.java_conf.simpleblogapi.application.file.dto.RegisterFileArgsDto;
import jp.gr.java_conf.simpleblogapi.application.file.dto.RegisterFileResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileUploadService {

    private final FileService fileService;

    public RegisterFileResultDto registerFile(RegisterFileArgsDto registerFileArgsDto) {
        String fileName = fileService.registerFile(registerFileArgsDto);

        return RegisterFileResultDto.of(fileName);
    }
}
