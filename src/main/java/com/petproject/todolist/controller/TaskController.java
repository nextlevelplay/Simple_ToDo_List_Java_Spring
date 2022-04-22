package com.petproject.todolist.controller;

import com.petproject.todolist.core.ShowAllTaskService;
import com.petproject.todolist.dto.ShowAllTaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/todos")
public class TaskController {

    @Autowired
    private ShowAllTaskService showAllTaskService;

    @ResponseBody
    @GetMapping
    public ResponseEntity<ShowAllTaskResponse> findAll() {
        var response = showAllTaskService.showAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }




}
