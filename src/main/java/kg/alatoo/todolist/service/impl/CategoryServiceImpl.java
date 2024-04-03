package kg.alatoo.todolist.service.impl;

import kg.alatoo.todolist.entity.Category;
import kg.alatoo.todolist.repository.CategoryRepository;
import kg.alatoo.todolist.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category findById(long id){
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }

    @Override
    public List<Category> findAll(){return categoryRepository.findAll();}

    @Override
    public void createCategory(Category category) {

    }

}
