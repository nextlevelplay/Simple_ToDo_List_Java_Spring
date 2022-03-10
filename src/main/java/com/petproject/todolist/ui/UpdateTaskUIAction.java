package com.petproject.todolist.ui;

import com.petproject.todolist.core.FindByIdTaskService;
import com.petproject.todolist.core.ShowAllTaskService;
import com.petproject.todolist.core.UpdateTaskService;
import com.petproject.todolist.dto.UpdateTaskRequest;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UpdateTaskUIAction implements UIAction {

    private ShowAllTaskService showAllTaskService;
    private UpdateTaskService updateTaskService;
    private FindByIdTaskService findByIdTaskService;

    public UpdateTaskUIAction(ShowAllTaskService showAllTaskService,
                              UpdateTaskService updateTaskService, FindByIdTaskService findByIdTaskService) {
        this.showAllTaskService = showAllTaskService;
        this.updateTaskService = updateTaskService;
        this.findByIdTaskService = findByIdTaskService;
    }

    @Override
    public void execute() {

        System.out.println("\033[H\033[2J");
        System.out.flush();

        // Print data
        System.out.println("All Tasks what we have at this moment: ");
        var showAllResponse = showAllTaskService.showAllToDo();
        System.out.println("******************************");
        System.out.println("Received response: " + showAllResponse);
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

        var request = new UpdateTaskRequest(id,newName,newDescription);
        System.out.println("******************************");
        System.out.println("Received request: " + request);

        // Use Service to update the Task
        var response = updateTaskService.updateToDo(request);
        System.out.println("******************************");
        System.out.println("Received response: " + response);
    }
}

