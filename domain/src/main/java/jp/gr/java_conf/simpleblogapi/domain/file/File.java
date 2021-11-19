package jp.gr.java_conf.simpleblogapi.domain.file;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class File {

    private final byte[] file;
    private final FileType fileType;
}
