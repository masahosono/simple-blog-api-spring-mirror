package jp.gr.java_conf.simpleblogapi.domain.category;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class Category {

    private final int id;
    private final String name;
    private final Integer parentId;

}
