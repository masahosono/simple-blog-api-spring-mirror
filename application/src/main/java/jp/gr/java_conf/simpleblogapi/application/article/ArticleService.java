package jp.gr.java_conf.simpleblogapi.application.article;

import jp.gr.java_conf.simpleblogapi.application.article.dto.EditArticleArgsDto;
import jp.gr.java_conf.simpleblogapi.application.article.dto.PostArticleArgsDto;
import jp.gr.java_conf.simpleblogapi.domain.article.Article;
import jp.gr.java_conf.simpleblogapi.domain.article.ArticleList;
import jp.gr.java_conf.simpleblogapi.domain.article.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleList getArticle() {
        return articleRepository.getArticle();
    }

    public Article getArticleById(String articleId) {
        return articleRepository.getArticleById(articleId);
    }

    public int getArticleCount() {
        return articleRepository.getArticleCount();
    }

    public void registerArticle(PostArticleArgsDto postArticleArgsDto) {
        articleRepository.registerArticle(
                postArticleArgsDto.getTitle(),
                postArticleArgsDto.getCategoryId(),
                postArticleArgsDto.getDescription(),
                postArticleArgsDto.getText(),
                postArticleArgsDto.getRequestedDateTime().getValue());
    }

    public void editArticle(EditArticleArgsDto editArticleArgsDto) {
        articleRepository.eidtArticle(
                editArticleArgsDto.getId(),
                editArticleArgsDto.getTitle(),
                editArticleArgsDto.getCategoryId(),
                editArticleArgsDto.getDescription(),
                editArticleArgsDto.getText(),
                editArticleArgsDto.getRequestedDateTime().getValue());
    }

}
