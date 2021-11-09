package jp.gr.java_conf.simpleblogapi.domain.file;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FileType {
    JPEG("jpg"),
    PNG("png"),
    GIF("gif");

    private final String extension;

    public static FileType of(String contentType) {

        switch (contentType) {
            case "image/jpeg":
                return JPEG;
            case "image/png":
                return PNG;
            case "image/gif":
                return GIF;
            default:
                throw new IllegalArgumentException("Unsupported file type");
        }
    }
}
