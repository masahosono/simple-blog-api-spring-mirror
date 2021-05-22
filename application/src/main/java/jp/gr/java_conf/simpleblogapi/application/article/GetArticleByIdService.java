package jp.gr.java_conf.simpleblogapi.application.article;

import jp.gr.java_conf.simpleblogapi.application.article.dto.GetArticleByIdArgsDto;
import jp.gr.java_conf.simpleblogapi.application.article.dto.GetArticleByIdResultDto;
import jp.gr.java_conf.simpleblogapi.domain.article.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetArticleByIdService {

    private final ArticleService articleService;

    public GetArticleByIdResultDto getArticleById(GetArticleByIdArgsDto getArticleByIdArgsDto) {

        Article article = articleService.getArticleById(getArticleByIdArgsDto.getId());

        return GetArticleByIdResultDto.of(article);
    }
}
