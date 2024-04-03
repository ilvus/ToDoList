package kg.alatoo.todolist.controller;

import kg.alatoo.todolist.entity.Category;
import kg.alatoo.todolist.entity.Task;
import kg.alatoo.todolist.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {
    private final CategoryService service;


    public CategoryController(CategoryService categoryService) {
        this.service = categoryService;
    }
    @GetMapping("/detail")
    public Category detail(@PathVariable long id) {
        return this.service.findById(id);
    }

    @GetMapping("/list")
    public List<Category> tasks(){return service.findAll();}

    @PostMapping("/create")
    public String create(@RequestBody Category category){
        service.createCategory(category);
        return "ok";
    }
}
