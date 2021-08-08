package jp.gr.java_conf.simpleblogapi.infrastructure.category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryEntity {

    private int id;
    private String name;
    private Integer parent_id;
}