package pl.coderslab.category;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;

public class CategoryConverter implements Converter<String, Category> {

    @Autowired
    CategoryService categoryService;

    @Override
    public Category convert(String s) {
        return categoryService.findOne(Long.parseLong(s));
    }
}
