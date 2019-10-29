package pl.coderslab.article;

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
        return articleDao.findOne(id);
    }

    public void delete(Long id){
            articleDao.delete(id);
    }
}
