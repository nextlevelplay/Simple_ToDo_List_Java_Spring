package com.petproject.todolist.ui;
import com.petproject.todolist.core.CreateTaskService;
import com.petproject.todolist.dto.CreateTaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CreateTaskUIAction implements UIAction{

    @Autowired
    private CreateTaskService createTaskService;

    @Override
    public void execute() {

        System.out.println("\033[H\033[2J");
        System.out.flush();

        // Create scanner
        var scanner = new Scanner(System.in);
        var request = new CreateTaskRequest();

        // Asking user some data
        System.out.println("******************************");
        System.out.print("Please enter name of Task: ");
        request.setName(scanner.nextLine());
        System.out.print("Please enter description: ");
        request.setDescription(scanner.nextLine());
        System.out.print("Please enter user id: ");
        request.setUserId(Integer.parseInt(scanner.nextLine()));

        // Use Service to create Task
        var response = createTaskService.createToDo(request);
        System.out.println("******************************");
        System.out.println("Received response: " + response);
    }
}
