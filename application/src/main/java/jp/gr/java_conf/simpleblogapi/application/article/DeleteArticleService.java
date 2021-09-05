package jp.gr.java_conf.simpleblogapi.application.article;

import jp.gr.java_conf.simpleblogapi.application.article.dto.DeleteArticleArgsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteArticleService {

    private final ArticleService articleService;

    public void deleteArticle(DeleteArticleArgsDto deleteArticleArgsDto) {
        articleService.deleteArticle(deleteArticleArgsDto);
    }
}
