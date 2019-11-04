package pl.coderslab.article;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleService {

    private final ArticleDao articleDao;
    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleDao articleDao, ArticleRepository articleRepository) {
        this.articleDao = articleDao;
        this.articleRepository = articleRepository;
    }

    public List<Article> findNoOfLast(int limit){
        return articleDao.findNoOfLast(limit);
    }

    public void create(Article article){
        articleRepository.save(article);
    }

    public void update(Article article){
        articleRepository.save(article);
    }

    public Article findOne(Long id){
        Article article = articleRepository.findById(id).orElse(null);
//        article.getCategories();
        return article;
    }

    public Article findArticleWithCategories(Long id){
        Article article = articleRepository.findById(id).orElse(null);
        Hibernate.initialize(article.getCategories());
        return article;
    }

    public List<Article> findAll(){
        return articleRepository.findAll();
    }

    public List<Article> findAllDrafts(){
        return articleDao.findAllDarfts();
    }

    public void delete(Long id){
            articleRepository.deleteById(id);
    }
}
