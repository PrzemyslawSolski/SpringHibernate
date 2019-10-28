package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.article.ArticleService;
import pl.coderslab.category.CategoryService;

@Controller
public class HomeController {

    private final ArticleService articleService;
    private final CategoryService categoryService;

    @Autowired
    public HomeController(ArticleService articleService, CategoryService categoryService) {
        this.articleService = articleService;
        this.categoryService = categoryService;
    }

    @GetMapping("/last")
    @ResponseBody
    public String last() {
        return articleService.findNoOfLast(5).toString() + categoryService.findAll();
    }
}
