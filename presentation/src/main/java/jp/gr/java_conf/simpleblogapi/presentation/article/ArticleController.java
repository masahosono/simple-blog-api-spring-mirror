package jp.gr.java_conf.simpleblogapi.presentation.article;

import jp.gr.java_conf.simpleblogapi.application.article.GetArticleService;
import jp.gr.java_conf.simpleblogapi.application.article.dto.GetArticleResultDto;
import jp.gr.java_conf.simpleblogapi.presentation.article.deletearticle.response.DeleteArticleResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.editarticle.response.EditArticleResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response.GetArticlesResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response.factory.GetArticleResponseFactory;
import jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response.factory.GetArticleResponseEntityFactory;
import jp.gr.java_conf.simpleblogapi.presentation.article.postarticle.request.PostArticleRequest;
import jp.gr.java_conf.simpleblogapi.presentation.article.postarticle.response.PostArticleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
@RequiredArgsConstructor
public class ArticleController {

    private final GetArticleService getArticleScenarioService;

    private final GetArticleResponseFactory getArticleResponseFactory;
    private final GetArticleResponseEntityFactory getArticleResponseEntityFactory;

    @GetMapping(path = "/api/article", produces = "application/json")
    public ResponseEntity<GetArticlesResponse> getArticle() {
        GetArticleResultDto getArticleResultDto =
                getArticleScenarioService.getArticle();

        return getArticleResponseEntityFactory.create(
                getArticleResponseFactory.create(getArticleResultDto));
    }

    @PostMapping(path = "/api/article", produces = "application/json")
    public ResponseEntity<PostArticleResponse> postArticle(
            @RequestBody PostArticleRequest requestBody) {
        return null;
    }

    @PutMapping(path = "/api/article", produces = "application/json")
    public ResponseEntity<EditArticleResponse> putArticle() {
        return null;
    }

    @DeleteMapping(path = "/api/article", produces = "application/json")
    public ResponseEntity<DeleteArticleResponse> deleteArticle() {
        return null;
    }

}