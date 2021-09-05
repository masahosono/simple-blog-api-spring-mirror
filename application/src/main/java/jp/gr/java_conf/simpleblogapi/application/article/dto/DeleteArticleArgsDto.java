package jp.gr.java_conf.simpleblogapi.application.article.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class DeleteArticleArgsDto {

    private final String id;

}
