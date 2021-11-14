package jp.gr.java_conf.simpleblogapi.presentation.file.postfile.response.factory;

import jp.gr.java_conf.simpleblogapi.presentation.file.postfile.response.PostFileResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PostFileResponseEntityFactory {

    public ResponseEntity<PostFileResponse> create(PostFileResponse response) {
        return new ResponseEntity<PostFileResponse>(
                response,
                HttpStatus.OK);
    }
}
