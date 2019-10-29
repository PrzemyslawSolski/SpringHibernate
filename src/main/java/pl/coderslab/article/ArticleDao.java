package pl.coderslab.article;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import pl.coderslab.author.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Article article){
        entityManager.persist(article);
    }

    public void update(Article article){
        entityManager.merge(article);
    }

    public Article findOne(Long id){
        return entityManager.find(Article.class, id);
    }

//    public Article FindArticleWithCategories(Long id){
//        Article article = findOne(id);
//        Hibernate.initialize(article.getCategories());
//        return article;
//    }

    public List<Article> findNoOfLast(int limit){
        Query query = entityManager.createQuery("select a from Article a order by a.created desc");
            query.setMaxResults(limit);
        return query.getResultList();
    }

    public List<Article> findAll(){
        Query query = entityManager.createQuery("select a from Article a");
        return query.getResultList();
    }

    public void delete(Long id){
        Article article = findOne(id);
        if (article != null){
            entityManager.remove(article);
        }
    }
}
