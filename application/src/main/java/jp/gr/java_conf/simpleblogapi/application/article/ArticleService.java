package jp.gr.java_conf.simpleblogapi.application.article;

import jp.gr.java_conf.simpleblogapi.application.article.dto.DeleteArticleArgsDto;
import jp.gr.java_conf.simpleblogapi.application.article.dto.EditArticleArgsDto;
import jp.gr.java_conf.simpleblogapi.application.article.dto.RegisterArticleArgsDto;
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

    public void registerArticle(RegisterArticleArgsDto registerArticleArgsDto) {
        articleRepository.registerArticle(
                registerArticleArgsDto.getTitle(),
                registerArticleArgsDto.getCategoryId(),
                registerArticleArgsDto.getDescription(),
                registerArticleArgsDto.getText(),
                registerArticleArgsDto.getRequestedDateTime().getValue());
    }

    public void editArticle(EditArticleArgsDto editArticleArgsDto) {
        articleRepository.editArticle(
                editArticleArgsDto.getId(),
                editArticleArgsDto.getTitle(),
                editArticleArgsDto.getCategoryId(),
                editArticleArgsDto.getDescription(),
                editArticleArgsDto.getText(),
                editArticleArgsDto.getRequestedDateTime().getValue());
    }

    public void deleteArticle(DeleteArticleArgsDto deleteArticleArgsDto) {
        articleRepository.deleteArticle(
                deleteArticleArgsDto.getId());
    }

}
