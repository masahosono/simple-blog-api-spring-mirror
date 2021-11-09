package jp.gr.java_conf.simpleblogapi.infrastructure.file;

import java.io.IOException;
import jp.gr.java_conf.simpleblogapi.domain.file.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Repository
@RequiredArgsConstructor
public class FileRepositoryImpl implements FileRepository {

    private final JdbcTemplate jdbcTemplate;

    public void registerFile(MultipartFile multipartFile, String fileName) {
        String query = "insert into " +
                "file(name, content_type, file, original_name) " +
                "values(?,?,?,?)";

        log.info(multipartFile.getContentType());

        try {
            jdbcTemplate.update(
                    query,
                    fileName,
                    multipartFile.getContentType(),
                    multipartFile.getBytes(),
                    multipartFile.getOriginalFilename());
        } catch (RuntimeException exception) {
            throw exception; // TODO: Error Handling
        } catch (IOException exception) {
        }
    }
}