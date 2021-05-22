package jp.gr.java_conf.simpleblogapi.presentation.article.getarticlebyid.request.dto.factory;

import jp.gr.java_conf.simpleblogapi.application.article.dto.GetArticleByIdArgsDto;
import org.springframework.stereotype.Component;

@Component
public class GetArticleByIdArgsDtoFactory {

    public GetArticleByIdArgsDto create(String id) {
        return GetArticleByIdArgsDto.of(id);
    }

}
