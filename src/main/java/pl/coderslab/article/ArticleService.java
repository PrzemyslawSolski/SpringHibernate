package pl.coderslab.article;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class ArticleService {

    private final ArticleDao articleDao;

    @Autowired
    public ArticleService(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    public List<Article> findNoOfLast(int limit){
        return articleDao.findNoOfLast(limit);
    }

    public void create(Article article){
        articleDao.create(article);
    }

    public void update(Article article){
        articleDao.update(article);
    }

    public Article findOne(Long id){
        Article article = articleDao.findOne(id);
//        article.getCategories();
        return article;
    }

    public Article findArticleWithCategories(Long id){
        Article article = articleDao.findOne(id);
        Hibernate.initialize(article.getCategories());
        return article;
    }

    public List<Article> findAll(){
        return articleDao.findAll();
    }

    public void delete(Long id){
            articleDao.delete(id);
    }
}
