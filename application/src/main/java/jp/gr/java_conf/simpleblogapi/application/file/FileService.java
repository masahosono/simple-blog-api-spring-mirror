package jp.gr.java_conf.simpleblogapi.application.file;

import java.time.format.DateTimeFormatter;
import jp.gr.java_conf.simpleblogapi.application.file.dto.RegisterFileArgsDto;
import jp.gr.java_conf.simpleblogapi.domain.file.File;
import jp.gr.java_conf.simpleblogapi.domain.file.FileRepository;
import jp.gr.java_conf.simpleblogapi.domain.file.FileType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;

    public String registerFile(RegisterFileArgsDto registerFileArgsDto) {

        FileType fileType =
                FileType.of(registerFileArgsDto.getMultipartFile().getContentType());

        String fileName =
                registerFileArgsDto.getLocalDateTime().format(
                        DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + "." + fileType.getExtension();

        fileRepository.registerFile(registerFileArgsDto.getMultipartFile(), fileName);

        return fileName;
    }

    public File getFile(String fileName) {

        return fileRepository.getFile(fileName);
    }

}
