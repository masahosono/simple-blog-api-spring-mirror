package jp.gr.java_conf.simpleblogapi.application.article.dto;

import jp.gr.java_conf.simpleblogapi.domain.datetime.RequestedDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class PostArticleArgsDto {

    private final String title;
    private final int categoryId;
    private final String description;
    private final String text;
    private final RequestedDateTime requestedDateTime;
}
