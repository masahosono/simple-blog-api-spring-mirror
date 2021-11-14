package jp.gr.java_conf.simpleblogapi.application.file.dto;

import jp.gr.java_conf.simpleblogapi.domain.file.FileType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class GetFileResultDto {

    private final byte[] file;
    private final FileType fileType;

}
