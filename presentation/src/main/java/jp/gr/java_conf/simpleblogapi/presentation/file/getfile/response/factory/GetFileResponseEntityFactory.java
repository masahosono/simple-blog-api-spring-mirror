package jp.gr.java_conf.simpleblogapi.presentation.file.getfile.response.factory;

import jp.gr.java_conf.simpleblogapi.application.file.dto.GetFileResultDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetFileResponseEntityFactory {

    private final ContentTypeConverter contentTypeConverter;

    public ResponseEntity<byte[]> create(GetFileResultDto getFileResultDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(
                contentTypeConverter.convertFromFileType(getFileResultDto.getFileType()));

        return new ResponseEntity<>(
                getFileResultDto.getFile(),
                headers,
                HttpStatus.OK);
    }
}
