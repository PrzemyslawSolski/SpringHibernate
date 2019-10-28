package pl.coderslab.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CategoryService {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public void create(Category category) {
        categoryDao.create(category);
    }

    public void update(Category category) {
        categoryDao.update(category);
    }

    public Category findOne(Long id) {
        return categoryDao.findOne(id);
    }

    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    public void delete(Long id) {
        categoryDao.delete(id);
    }
}
