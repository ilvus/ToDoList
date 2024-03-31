package kg.alatoo.todolist.service;

import kg.alatoo.todolist.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {
    public Category findById(long id);
    List<Category> findAll();
    public void createCategory(Category category);
}
