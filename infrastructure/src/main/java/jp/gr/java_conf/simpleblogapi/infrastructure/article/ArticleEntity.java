package jp.gr.java_conf.simpleblogapi.infrastructure.article;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleEntity {

    private String id;
    private String title;
    private int category_id;
    private Date create_date_time;
    private Date update_date_time;
    private String description;
    private String text;
    private int disp_flg;

}