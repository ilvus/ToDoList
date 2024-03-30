package kg.alatoo.todolist.service;

import kg.alatoo.todolist.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    public Task findById(long id);
    List<Task> findAll();
    public void createTask(Task task);
}
