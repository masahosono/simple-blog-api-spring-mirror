package jp.gr.java_conf.simpleblogapi.presentation.article.getarticlebyid.response.factory;

import jp.gr.java_conf.simpleblogapi.presentation.article.getarticlebyid.response.GetArticleByIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetArticleByIdResponseEntityFactory {

    public ResponseEntity<GetArticleByIdResponse> create(
            GetArticleByIdResponse response) {
        return new ResponseEntity<>(
                response,
                HttpStatus.OK);
    }

}
