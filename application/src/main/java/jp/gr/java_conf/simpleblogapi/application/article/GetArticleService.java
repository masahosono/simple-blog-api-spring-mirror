package jp.gr.java_conf.simpleblogapi.application.article;

import jp.gr.java_conf.simpleblogapi.application.article.dto.GetArticleResultDto;
import jp.gr.java_conf.simpleblogapi.domain.article.ArticleList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetArticleService {

    private final ArticleService getArticleService;

    public GetArticleResultDto getArticle() {

        ArticleList articleList = getArticleService.getArticle();
        return GetArticleResultDto.of(articleList);
    }
}
