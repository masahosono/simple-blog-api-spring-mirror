package jp.gr.java_conf.simpleblogapi.infrastructure.file;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileEntity {

    private String name;
    private String original_name;
    private String content_type;
    private byte[] file;
}
