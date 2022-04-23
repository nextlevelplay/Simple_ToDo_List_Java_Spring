package com.petproject.todolist.controller;

import com.petproject.todolist.core.*;
import com.petproject.todolist.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/putExample")
@AllArgsConstructor
public class TaskController {

    @Autowired
    private ShowAllTaskService showAllTaskService;
    @Autowired
    private FindByIdTaskService findByIdTaskService;
    @Autowired
    private CreateTaskService createTaskService;
    @Autowired
    private UpdateTaskService updateTaskService;
    @Autowired
    private RemoveTaskService removeTaskService;

    @GetMapping("/getAll")
    public ShowAllTaskResponse findAll() {
        var response = showAllTaskService.showAll();
        return response;
    }

    @GetMapping("/getAll/{id}")
    public FindByIdTaskResponse findByIdTask(@PathVariable("id") Integer id) {
        var response = findByIdTaskService.findById(id);
        return response;
    }

    @PostMapping("/create")
    public CreateTaskResponse createTask(@RequestBody CreateTaskRequest request) {
        return createTaskService.createToDo(request);
    }

    @PutMapping("/update")
    public UpdateTaskResponse updateTask(@RequestBody UpdateTaskRequest request) {
        return updateTaskService.updateToDo(request);
    }

    @DeleteMapping("/delete/{id}")
    public void removeTask(@PathVariable("id") Integer id) {
        removeTaskService.removeToDo(id);

    }

}
