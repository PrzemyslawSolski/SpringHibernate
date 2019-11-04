package pl.coderslab.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/list")
    public String show(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "categories";
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id) {
        categoryService.delete(id);
        return "redirect:../list";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("category", new Category());
        return "category";
    }

    @PostMapping("/add")
    public String add(Model model, @Valid @ModelAttribute Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category";
        }
        categoryService.create(category);
        return ("redirect:list");
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("category", categoryService.findOne(id));
        return "category";
    }

    @PostMapping("/edit/{id}")
    public String edit(Model model, @Valid @ModelAttribute Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category";
        }
        categoryService.update(category);
        return "redirect:../list";
    }

}
