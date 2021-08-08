package jp.gr.java_conf.simpleblogapi.domain.category;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
@Getter
public class ResolvedCategory {

    private final int id;
    private final String name;
    private final long articleNumber;
    private final Integer parentId;
}
