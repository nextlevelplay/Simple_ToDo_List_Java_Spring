package com.petproject.todolist.controller.ui;

import com.petproject.todolist.core.CreateTaskService;
import com.petproject.todolist.core.ShowAllTaskService;
import com.petproject.todolist.dto.CreateTaskRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class UIController {

    @Autowired
    private ShowAllTaskService showAllTaskService;
    @Autowired
    private CreateTaskService createTaskService;


    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/allTasks")
    public String getAllTasks(Model model) {
        var response = showAllTaskService.showAll();
        model.addAttribute("tasks", response.getTasks());
        return "showAllTasks";
    }

    @GetMapping("/allUsers")
    public String getAllUsers() {
        return "showAllUsers";
    }

    @GetMapping("/createTask")
    public String createTaskView(Model model) {
        model.addAttribute("task", new CreateTaskRequest());
        return "createTask";
    }

    @PostMapping("/createTask")
    public String createTask(@ModelAttribute CreateTaskRequest task) {
        createTaskService.createToDo(task);
        return "redirect:/allTasks";
    }


}
