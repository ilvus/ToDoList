package kg.alatoo.todolist.services.impl;


import kg.alatoo.todolist.dto.TaskDto;
import kg.alatoo.todolist.entity.Task;
import kg.alatoo.todolist.exception.ApplicationException;
import kg.alatoo.todolist.mapper.TaskMapper;
import kg.alatoo.todolist.repository.CategoryRepository;
import kg.alatoo.todolist.repository.TaskRepository;
import kg.alatoo.todolist.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {


    private final TaskRepository taskRepository;
    private final CategoryRepository categoryRepository;
    private final TaskMapper taskMapper;

    @Override
    public Task createTask(TaskDto newTask) {
        return taskRepository.save(taskMapper.toEntity(newTask));
    }

    @Override
    public Task updateTask(Long taskId, TaskDto updatedTask) {
        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new ApplicationException("TASK_NOT_FOUND", "Task not found", org.springframework.http.HttpStatus.NOT_FOUND)
        );
        if(updatedTask.getTitle() != null) {
            task.setTitle(updatedTask.getTitle());
        }
        if(updatedTask.getDescription() != null) {
            task.setDescription(updatedTask.getDescription());
        }
        if(updatedTask.getCategoryId() != null) {
            task.setCategory(categoryRepository.findById(updatedTask.getCategoryId()).orElseThrow());
        }
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new ApplicationException("TASK_NOT_FOUND", "Task not found", org.springframework.http.HttpStatus.NOT_FOUND)
        );
        taskRepository.deleteById(taskId);
    }

    @Override
    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElseThrow(
                () -> new ApplicationException("TASK_NOT_FOUND", "Task not found", org.springframework.http.HttpStatus.NOT_FOUND)
        );
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task completeTask(Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new ApplicationException("TASK_NOT_FOUND", "Task not found", org.springframework.http.HttpStatus.NOT_FOUND)
        );
        task.setCompleted(true);
        return taskRepository.save(task);
    }
}
