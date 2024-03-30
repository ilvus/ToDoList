package kg.alatoo.todolist.service.impl;

import kg.alatoo.todolist.entity.Task;
import kg.alatoo.todolist.repository.TaskRepository;
import kg.alatoo.todolist.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public Task findById(long id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.orElse(null);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public void createTask(Task task) {
        taskRepository.save(task);

    }
}
