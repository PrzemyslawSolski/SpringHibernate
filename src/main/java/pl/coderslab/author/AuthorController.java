package pl.coderslab.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.category.Category;

import javax.validation.Valid;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping("/list")
    public String show(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "authors";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id) {
        authorService.delete(id);
        return "redirect:../list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("author", new Author());
        return "author";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute Author author, BindingResult result) {
        if(result.hasErrors()){
            return "author";
        }
        authorService.create(author);
        return ("redirect:list");
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("author", authorService.findOne(id));
        return "author";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid @ModelAttribute Author author, BindingResult result) {
        if(result.hasErrors()){
            return "author";
        }
        authorService.update(author);
        return "redirect:../list";
    }

}
