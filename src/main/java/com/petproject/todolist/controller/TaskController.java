package com.petproject.todolist.controller;

import com.petproject.todolist.core.FindByIdTaskService;
import com.petproject.todolist.core.ShowAllTaskService;
import com.petproject.todolist.dto.FindByIdTaskResponse;
import com.petproject.todolist.dto.ShowAllTaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TaskController {

    @Autowired
    private ShowAllTaskService showAllTaskService;
    @Autowired
    private FindByIdTaskService findByIdTaskService;

    // Simple response
    @GetMapping
    public ShowAllTaskResponse findAll() {
        return showAllTaskService.showAll();
    }

    @GetMapping("/{id}")
    public FindByIdTaskResponse findByIdTask(@PathVariable("id") Integer id) {
        return findByIdTaskService.findById(id);
    }

    // Special response with status
//    @ResponseBody
//    @GetMapping
//    public ResponseEntity<ShowAllTaskResponse> findAll() {
//        var response = showAllTaskService.showAll();
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }




}
