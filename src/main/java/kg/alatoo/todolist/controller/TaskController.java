package kg.alatoo.todolist.controller;

import kg.alatoo.todolist.entity.Task;
import kg.alatoo.todolist.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/task")
public class TaskController {
    private final TaskService service;
    public TaskController(TaskService taskService) {
        this.service = taskService;
    }


    @GetMapping("/detail")
    public Task detail(@PathVariable long id) {
        return this.service.findById(id);
    }

    @GetMapping("/list")
    public List<Task> tasks(){return service.findAll();}

    @PostMapping("/create")
    public String create(@RequestBody Task task){
        service.createTask(task);
        return "ok";
    }


}
