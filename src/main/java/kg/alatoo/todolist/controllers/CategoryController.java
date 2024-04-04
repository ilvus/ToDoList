package kg.alatoo.todolist.controllers;


import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kg.alatoo.todolist.dto.CategoryDto;
import kg.alatoo.todolist.entity.Category;
import kg.alatoo.todolist.services.impl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryServiceImpl categoryService;

    @Operation(summary = "Create category")
    @PostMapping()
    public ResponseEntity<Category> createCategory(@Valid @RequestBody CategoryDto category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @Operation(summary = "Update category")
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable(name = "id") Long categoryId,@Valid @RequestBody CategoryDto   category) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryId, category));
    }

    @Operation(summary = "Delete category")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable(name = "id") Long categoryId) {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get category by id")
    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long categoryId) {
        return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
    }

    @Operation(summary = "Get all categories")
    @GetMapping()
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
