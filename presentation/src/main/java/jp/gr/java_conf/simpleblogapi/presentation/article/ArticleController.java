package jp.gr.java_conf.simpleblogapi.presentation.article;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jp.gr.java_conf.simpleblogapi.application.article.DeleteArticleService;
import jp.gr.java_conf.simpleblogapi.application.article.EditArticleService;
import jp.gr.java_conf.simpleblogapi.application.article.GetArticleByIdService;
import jp.gr.java_conf.simpleblogapi.application.article.GetArticleService;
import jp.gr.java_conf.simpleblogapi.application.article.RegisterArticleService;
import jp.gr.java_conf.simpleblogapi.application.article.dto.DeleteArticleArgsDto;
import jp.gr.java_conf.simpleblogapi.application.article.dto.EditArticleArgsDto;
import jp.gr.java_conf.simpleblogapi.application.article.dto.EditArticleResultDto;
import jp.gr.java_conf.simpleblogapi.application.article.dto.GetArticleByIdArgsDto;
import jp.gr.java_conf.simpleblogapi.application.article.dto.GetArticleByIdResultDto;
import jp.gr.java_conf.simpleblogapi.application.article.dto.GetArticleResultDto;
import jp.gr.java_conf.simpleblogapi.application.article.dto.RegisterArticleArgsDto;
import jp.gr.java_conf.simpleblogapi.application.article.dto.RegisterArticleResultDto;
import jp.gr.java_conf.simpleblogapi.domain.datetime.RequestedDateTime;
import jp.gr.java_conf.simpleblogapi.presentation.article.deletearticle.request.dto.factory.DeleteArticleArgsDtoFactory;
import jp.gr.java_conf.simpleblogapi.presentation.article.deletearticle.response.DeleteArticleResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.deletearticle.response.factory.DeleteArticleResponseEntityFactory;
import jp.gr.java_conf.simpleblogapi.presentation.article.deletearticle.response.factory.DeleteArticleResponseFactory;
import jp.gr.java_conf.simpleblogapi.presentation.article.editarticle.request.EditArticleRequest;
import jp.gr.java_conf.simpleblogapi.presentation.article.editarticle.request.factory.EditArticleArgsDtoFactory;
import jp.gr.java_conf.simpleblogapi.presentation.article.editarticle.response.EditArticleResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.editarticle.response.factory.EditArticleResponseEntityFactory;
import jp.gr.java_conf.simpleblogapi.presentation.article.editarticle.response.factory.EditArticleResponseFactory;
import jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response.GetArticleResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response.factory.GetArticleResponseFactory;
import jp.gr.java_conf.simpleblogapi.presentation.article.getarticle.response.factory.GetArticleResponseEntityFactory;
import jp.gr.java_conf.simpleblogapi.presentation.article.getarticlebyid.request.dto.factory.GetArticleByIdArgsDtoFactory;
import jp.gr.java_conf.simpleblogapi.presentation.article.getarticlebyid.response.GetArticleByIdResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.getarticlebyid.response.factory.GetArticleByIdResponseEntityFactory;
import jp.gr.java_conf.simpleblogapi.presentation.article.getarticlebyid.response.factory.GetArticleByIdResponseFactory;
import jp.gr.java_conf.simpleblogapi.presentation.article.registerarticle.request.RegisterArticleRequest;
import jp.gr.java_conf.simpleblogapi.presentation.article.registerarticle.request.dto.factory.RegisterArticleArgsDtoFactory;
import jp.gr.java_conf.simpleblogapi.presentation.article.registerarticle.response.RegisterArticleResponse;
import jp.gr.java_conf.simpleblogapi.presentation.article.registerarticle.response.factory.RegisterArticleResponseEntityFactory;
import jp.gr.java_conf.simpleblogapi.presentation.article.registerarticle.response.factory.RegisterArticleResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "記事API")
@RestController
@Component
@RequiredArgsConstructor
public class ArticleController {

    private final GetArticleService getArticleScenarioService;
    private final GetArticleResponseFactory getArticleResponseFactory;
    private final GetArticleResponseEntityFactory getArticleResponseEntityFactory;

    private final GetArticleByIdService getArticleByIdService;
    private final GetArticleByIdArgsDtoFactory getArticleByIdArgsDtoFactory;
    private final GetArticleByIdResponseFactory getArticleByIdResponseFactory;
    private final GetArticleByIdResponseEntityFactory getArticleByIdResponseEntityFactory;

    private final RegisterArticleService registerArticleService;
    private final RegisterArticleArgsDtoFactory registerArticleArgsDtoFactory;
    private final RegisterArticleResponseFactory registerArticleResponseFactory;
    private final RegisterArticleResponseEntityFactory registerArticleResponseEntityFactory;

    private final EditArticleService editArticleService;
    private final EditArticleArgsDtoFactory editArticleArgsDtoFactory;
    private final EditArticleResponseFactory editArticleResponseFactory;
    private final EditArticleResponseEntityFactory editArticleResponseEntityFactory;

    private final DeleteArticleService deleteArticleService;
    private final DeleteArticleArgsDtoFactory deleteArticleArgsDtoFactory;
    private final DeleteArticleResponseFactory deleteArticleResponseFactory;
    private final DeleteArticleResponseEntityFactory deleteArticleResponseEntityFactory;

    @Operation(summary = "記事取得API", description = "公開済み記事情報の取得と返却を行う")
    @GetMapping(path = "/api/article", produces = "application/json")
    public ResponseEntity<GetArticleResponse> getArticle() {
        GetArticleResponse response;
        try {
            GetArticleResultDto getArticleResultDto =
                    getArticleScenarioService.getArticle();
            response = getArticleResponseFactory.createForSuccess(getArticleResultDto);
        } catch (RuntimeException exception) {
            response = getArticleResponseFactory.createForError(exception);
        }

        return getArticleResponseEntityFactory.create(response);
    }

    @Operation(summary = "単一記事取得API", description = "指定した記事IDに紐づく記事情報の取得と返却を行う")
    @GetMapping(path = "/api/article/{id}", produces = "application/json")
    public ResponseEntity<GetArticleByIdResponse> getArticleById(
            @Schema(description = "記事ID") @PathVariable("id") String id) {

        GetArticleByIdResponse response;
        try {
            GetArticleByIdArgsDto getArticleByIdArgsDto =
                    getArticleByIdArgsDtoFactory.create(id);

            GetArticleByIdResultDto getArticleByIdResultDto =
                    getArticleByIdService.getArticleById(getArticleByIdArgsDto);

            response = getArticleByIdResponseFactory.createForSuccess(getArticleByIdResultDto);
        } catch (RuntimeException exception) {
            response = getArticleByIdResponseFactory.createForError(exception);
        }

        return getArticleByIdResponseEntityFactory.create(response);
    }

    @Operation(summary = "記事登録API", description = "新規記事の登録を行う")
    @PostMapping(path = "/api/article", produces = "application/json")
    public ResponseEntity<RegisterArticleResponse> registerArticle(
            @RequestBody RegisterArticleRequest requestBody,
            @Parameter(hidden = true) RequestedDateTime requestedDateTime) {

        RegisterArticleResponse response;
        try {
            RegisterArticleArgsDto registerArticleArgsDto =
                    registerArticleArgsDtoFactory.create(requestBody, requestedDateTime);

            RegisterArticleResultDto registerArticleResultDto =
                    registerArticleService.registerArticle(registerArticleArgsDto);

            response = registerArticleResponseFactory.createForSuccess(registerArticleResultDto);
        } catch (RuntimeException exception) {
            response = registerArticleResponseFactory.createForError(exception);
        }

        return registerArticleResponseEntityFactory.create(response);
    }

    @Operation(summary = "記事編集API", description = "登録済み記事情報の変更を行う")
    @PutMapping(path = "/api/article/{id}", produces = "application/json")
    public ResponseEntity<EditArticleResponse> editArticle(
            @Schema(description = "記事ID") @PathVariable("id") String id,
            @RequestBody EditArticleRequest requestBody,
            @Parameter(hidden = true) RequestedDateTime requestedDateTime) {

        EditArticleResponse response;
        try {
            EditArticleArgsDto editArticleArgsDto =
                    editArticleArgsDtoFactory.create(id, requestBody, requestedDateTime);

            EditArticleResultDto editArticleResultDto =
                    editArticleService.editArticle(editArticleArgsDto);

            response = editArticleResponseFactory.createForSuccess(editArticleResultDto);
        } catch (RuntimeException exception) {
            response = editArticleResponseFactory.createForError(exception);
        }

        return editArticleResponseEntityFactory.create(response);
    }

    @Operation(summary = "記事削除API", description = "登録済み記事情報の削除を行う")
    @DeleteMapping(path = "/api/article/{id}", produces = "application/json")
    public ResponseEntity<DeleteArticleResponse> deleteArticle(
            @Schema(description = "記事ID") @PathVariable("id") String id) {

        DeleteArticleResponse response;
        try {
            DeleteArticleArgsDto deleteArticleArgsDto = deleteArticleArgsDtoFactory.create(id);
            deleteArticleService.deleteArticle(deleteArticleArgsDto);

            response = deleteArticleResponseFactory.createForSuccess();
        } catch (RuntimeException exception) {
            response = deleteArticleResponseFactory.createForError(exception);
        }

        return deleteArticleResponseEntityFactory.create(response);
    }

}