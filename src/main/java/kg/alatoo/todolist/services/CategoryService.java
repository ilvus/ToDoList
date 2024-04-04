package kg.alatoo.todolist.services;

import kg.alatoo.todolist.dto.CategoryDto;
import kg.alatoo.todolist.entity.Category;

import java.util.List;

public interface CategoryService {


    Category createCategory(CategoryDto categoryName);

    Category updateCategory(Long categoryId, CategoryDto categoryName);

    void deleteCategory(Long categoryId);

    Category getCategoryById(Long categoryId);

    List<Category> getAllCategories();
}
