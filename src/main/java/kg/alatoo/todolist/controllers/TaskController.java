package kg.alatoo.todolist.controllers;


import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import kg.alatoo.todolist.dto.TaskDto;
import kg.alatoo.todolist.entity.Task;
import kg.alatoo.todolist.services.impl.TaskServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskServiceImpl taskService;

    @Operation(summary = "Create task")
    @PostMapping()
    public ResponseEntity<Task> createTask(@Valid @RequestBody TaskDto task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @Operation(summary = "Update task")
    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable(name = "taskId") Long taskId,@Valid @RequestBody TaskDto task) {
        return ResponseEntity.ok(taskService.updateTask(taskId, task));
    }

    @Operation(summary = "Delete task")
    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable(name = "taskId") Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get task by id")
    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskId) {
        return ResponseEntity.ok(taskService.getTaskById(taskId));
    }

    @Operation(summary = "Get all tasks")
    @GetMapping()
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }
}
