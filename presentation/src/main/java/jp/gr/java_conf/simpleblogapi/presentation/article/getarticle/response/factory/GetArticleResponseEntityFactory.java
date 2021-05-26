package jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetArticleResponseEntityFactory {

    public ResponseEntity<GetArticlesResponse> create(GetArticlesResponse response) {
        return new ResponseEntity<>(
                response,
                HttpStatus.OK);
    }
}
