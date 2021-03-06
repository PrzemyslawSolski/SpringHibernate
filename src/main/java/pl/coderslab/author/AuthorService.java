package pl.coderslab.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorService {

    private final AuthorDao authorDao;

    @Autowired
    public AuthorService(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    public void create(Author author){
        authorDao.create(author);
    }

    public void update(Author author){
        authorDao.update(author);
    }

    public Author findOne(Long id){
        return authorDao.findOne(id);
    }

    public List<Author> findAll(){
        return authorDao.findAll();
    }



    public void delete(Long id){
        authorDao.delete(id);
    }
}
