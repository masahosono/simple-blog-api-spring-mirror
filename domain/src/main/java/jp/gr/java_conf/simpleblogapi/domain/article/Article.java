package jp.gr.java_conf.simpleblogapi.domain.article;

import java.util.Date;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class Article {

    private final String id;
    private final String title;
    private final int categoryId;
    private final Date createDate;
    private final Date updateDate;
    private final String description;
    private final String text;
}
