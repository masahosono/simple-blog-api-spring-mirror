package jp.gr.java_conf.simpleblogapi.domain.category;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class Category {

    private final int id;
    private final String name;
    private final Integer parentId;

    public ResolvedCategory resolve() {
        return ResolvedCategory.of(
                id,
                name,
                0, // TODO: 記事の個数の指定
                parentId
        );
    }

}
