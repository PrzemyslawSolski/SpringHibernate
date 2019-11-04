package pl.coderslab.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.author.Author;
import pl.coderslab.author.AuthorService;
import pl.coderslab.category.Category;
import pl.coderslab.category.CategoryService;
import pl.coderslab.validate.ArticleValidationGroup;
import pl.coderslab.validate.DraftValidationGroup;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/drafts")
public class DraftController {

    private final ArticleService articleService;
    private final CategoryService categoryService;
    private final AuthorService authorService;

    @Autowired
    public DraftController(ArticleService articleService, CategoryService categoryService, AuthorService authorService) {
        this.articleService = articleService;
        this.categoryService = categoryService;
        this.authorService = authorService;
    }


    @GetMapping("/list")
    public String show(Model model) {
        model.addAttribute("articles", articleService.findAllDrafts());
        return "articles";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id) {
        articleService.delete(id);
        return "redirect:../list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("article", new Article());
//        model.addAttribute()
        return "article";
    }

    @PostMapping("/add")
    public String add(@Validated(DraftValidationGroup.class)  @ModelAttribute Article article, BindingResult result) {
        if(result.hasErrors()){
            return "article";
        }
        article.setDraft(true);
        articleService.create(article);
        return ("redirect:list");
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("article", articleService.findArticleWithCategories(id));
        return "article";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Validated(DraftValidationGroup.class)  @ModelAttribute Article article, BindingResult result) {
        if(result.hasErrors()){
            return "article";
        }
        article.setDraft(true);
        articleService.update(article);
        return "redirect:../list";
    }


    @ModelAttribute("categories")
    public List<Category> getCategory() {
        return categoryService.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> getAuthor() {
        return authorService.findAll();
    }

}
