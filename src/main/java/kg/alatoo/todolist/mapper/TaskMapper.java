package kg.alatoo.todolist.mapper;

import kg.alatoo.todolist.dto.TaskDto;
import kg.alatoo.todolist.entity.Task;
import kg.alatoo.todolist.exception.ApplicationException;
import kg.alatoo.todolist.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class TaskMapper {

    private final CategoryRepository categoryRepository;

    public Task toEntity(TaskDto dto) {
        return Task.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .category(categoryRepository.findById(dto.getCategoryId()).orElseThrow(
                        () -> new ApplicationException("CATEGORY_NOT_FOUND", "Category not found", org.springframework.http.HttpStatus.NOT_FOUND)
                ))
                .completed(false)
                .build();
    }

}
