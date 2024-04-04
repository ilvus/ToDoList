package kg.alatoo.todolist.services;

import kg.alatoo.todolist.dto.TaskDto;
import kg.alatoo.todolist.entity.Task;

import java.util.List;

public interface TaskService {

    Task createTask(TaskDto newTask);

    Task updateTask(Long taskId, TaskDto updatedTask);

    void deleteTask(Long taskId);

    Task getTaskById(Long taskId);

    List<Task> getAllTasks();

    Task completeTask(Long taskId);

}
