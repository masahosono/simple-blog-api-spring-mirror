package jp.gr.java_conf.simpleblogapi.presentation.file.getfile.response.factory;

import jp.gr.java_conf.simpleblogapi.domain.file.FileType;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class ContentTypeConverter {

    public MediaType convertFromFileType(FileType fileType) {

        switch (fileType) {
            case JPEG:
                return MediaType.IMAGE_JPEG;
            case PNG:
                return MediaType.IMAGE_PNG;
            case GIF:
                return MediaType.IMAGE_GIF;
            default:
                throw new IllegalArgumentException("Unsupported file type");
        }
    }
}
