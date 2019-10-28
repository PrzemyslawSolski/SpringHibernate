package pl.coderslab.category;

import org.springframework.stereotype.Repository;
import pl.coderslab.article.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Queue;

@Repository
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Category category) {
        entityManager.persist(category);
    }

    public void update(Category category) {
        entityManager.merge(category);
    }

    public Category findOne(Long id) {
        return entityManager.find(Category.class, id);
    }

    public List<Category> findAll() {
        return entityManager.createQuery("select c from Category c").getResultList();
    }

    public void delete(Long id) {
        Category category = findOne(id);
        if (category != null) {
            entityManager.remove(category);
        }
    }
}
