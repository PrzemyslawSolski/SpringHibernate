package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.article.ArticleService;
import pl.coderslab.category.CategoryService;

import java.util.stream.Collectors;

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
//        articleService.findNoOfLast(5).stream().map(a->a.getContent().substring(0,200)).collect(Collectors.toList())
        return articleService.findNoOfLast(5)
//                .stream()
//                .forEach(a->a.setContent("a")).
//                        (a.getContent()
//                        .substring(0,a.getContent().length()>200?200:a.getContent().length())))
//                .collect(Collectors.toList())
                .toString()
                + categoryService.findAll();
    }
}
