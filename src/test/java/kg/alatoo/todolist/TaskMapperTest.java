package kg.alatoo.todolist;

import kg.alatoo.todolist.dto.TaskDto;
import kg.alatoo.todolist.entity.Category;
import kg.alatoo.todolist.entity.Task;
import kg.alatoo.todolist.mapper.TaskMapper;
import kg.alatoo.todolist.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class TaskMapperTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    public void whenConvertTaskDTOToTaskEntity_thenCorrect() {
        TaskDto dto = new TaskDto();
        dto.setTitle("Task Title");
        dto.setDescription("Task Description");;
        dto.setCategoryId(1L);

        Category mockCategory = new Category();
        mockCategory.setId(dto.getCategoryId());

        when(categoryRepository.findById(dto.getCategoryId())).thenReturn(Optional.of(mockCategory));

        Task task = taskMapper.toEntity(dto);

        assertEquals(dto.getTitle(), task.getTitle());
        assertEquals(dto.getDescription(), task.getDescription());
        assertEquals(dto.getCategoryId(), task.getCategory().getId());
    }
}
