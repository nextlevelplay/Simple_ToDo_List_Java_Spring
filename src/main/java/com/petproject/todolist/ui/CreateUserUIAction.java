package com.petproject.todolist.ui;

import com.petproject.todolist.core.UserService;
import com.petproject.todolist.dto.CreateTaskRequest;
import com.petproject.todolist.dto.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CreateUserUIAction implements UIAction{

    @Autowired
    private UserService userService;

    @Override
    public void execute() {

        System.out.println("\033[H\033[2J");
        System.out.flush();

        // Create scanner
        var scanner = new Scanner(System.in);
        var request = new CreateUserRequest();

        // Asking user some data
        System.out.println("******************************");
        System.out.print("Please enter user name: ");
        request.setUserName(scanner.nextLine());

        // Use Service to create Task
        var response = userService.createUser(request);
        System.out.println("******************************");
        System.out.println("Received response: " + response);
    }
}
