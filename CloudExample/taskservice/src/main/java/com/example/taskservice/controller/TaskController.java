package com.example.taskservice.controller;

import com.example.taskservice.model.Task;
import com.example.taskservice.model.TaskStatus;
import com.example.taskservice.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService service;

    @PostMapping
    public Task addTask(@RequestBody Task task){
        return service.createTask(task);
    }
    @GetMapping
    public List<Task> getAllTasks(){
        return service.getAllTasks();
    }
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return service.getTasksByStatus(status);
    }
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        return service.updateTaskStatus(id, task);
    }
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        service.deleteTask(id);
    }
}
