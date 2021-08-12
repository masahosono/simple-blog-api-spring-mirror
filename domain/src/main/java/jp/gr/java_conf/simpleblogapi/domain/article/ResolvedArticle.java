package jp.gr.java_conf.simpleblogapi.domain.article;

import java.util.Date;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(staticName = "of")
public class ResolvedArticle {

    private final String id;
    private final String title;
    private final int categoryId;
    private final String categoryName;
    private final Date createDateTime;
    private final Date updateDateTime;
    private final String description;
    private final String text;

}
