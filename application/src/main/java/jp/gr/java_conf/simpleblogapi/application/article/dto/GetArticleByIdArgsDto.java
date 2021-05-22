package jp.gr.java_conf.simpleblogapi.application.article.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class GetArticleByIdArgsDto {

    private final String id;

}
