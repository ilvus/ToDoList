package kg.alatoo.todolist.services.impl;

import kg.alatoo.todolist.dto.CategoryDto;
import kg.alatoo.todolist.entity.Category;
import kg.alatoo.todolist.exception.ApplicationException;
import kg.alatoo.todolist.repository.CategoryRepository;
import kg.alatoo.todolist.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category createCategory(CategoryDto categoryName) {
        Category category = new Category();
        category.setName(categoryName.getName());
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long categoryId, CategoryDto categoryName) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ApplicationException("CATEGORY_NOT_FOUND", "Category not found", HttpStatus.NOT_FOUND)
        );
        category.setName(categoryName.getName());
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ApplicationException("CATEGORY_NOT_FOUND", "Category not found", HttpStatus.NOT_FOUND)
        );
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow(
                () -> new ApplicationException("CATEGORY_NOT_FOUND", "Category not found", HttpStatus.NOT_FOUND)
        );
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
