package com.petproject.todolist.ui;

import com.petproject.todolist.core.FindByIdTaskService;
import com.petproject.todolist.core.ShowAllTaskService;
import com.petproject.todolist.core.UpdateTaskService;
import com.petproject.todolist.dto.UpdateTaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UpdateTaskUIAction implements UIAction {

    @Autowired
    private ShowAllTaskService showAllTaskService;
    @Autowired
    private UpdateTaskService updateTaskService;
    @Autowired
    private FindByIdTaskService findByIdTaskService;

    @Override
    public void execute() {

        System.out.println("\033[H\033[2J");
        System.out.flush();

        // Print data
        System.out.println("All Tasks what we have at this moment: ");
        var showAllResponse = showAllTaskService.showAll();
        showAllResponse.getTasks().forEach(System.out::println);
        System.out.println("______________________________");

        // Create scanner
        var scanner = new Scanner(System.in);

        // Asking user some data
        System.out.print("Please enter ID of the Task what you are should to update: ");
        var id = Integer.parseInt(scanner.nextLine());

        // Use Service to findByID
        var entity = findByIdTaskService.findById(id);
        System.out.println("******************************");
        System.out.print("Type new name: ");
        var newName = scanner.nextLine();
        System.out.print("Type new description: ");
        var newDescription = scanner.nextLine();

        var request = new UpdateTaskRequest();
        request.setId(entity.getTask().getId());
        request.setName(newName);
        request.setDescription(newDescription);
        request.setUserId(entity.getTask().getUserId());
        System.out.println("******************************");
        System.out.println("Received request: " + request);

        // Use Service to update the Task
        var response = updateTaskService.updateToDo(request);
        System.out.println("******************************");
        System.out.println("Received response: " + response);
    }
}

