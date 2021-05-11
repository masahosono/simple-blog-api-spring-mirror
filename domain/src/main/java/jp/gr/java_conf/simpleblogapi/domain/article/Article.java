package jp.gr.java_conf.simpleblogapi.domain.article;

import java.sql.Date;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class Article {

    private final int id;
    private final String title;
    private final String categoryId;
    private final Date createDate;
    private final Date updateDate;
    private final String text;
    private final int disp;
}
