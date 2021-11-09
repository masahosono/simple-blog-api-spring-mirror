package jp.gr.java_conf.simpleblogapi.domain.file;

import org.springframework.web.multipart.MultipartFile;

public interface FileRepository {

    void registerFile(MultipartFile multipartFile, String fileName);

}
