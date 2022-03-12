package com.petproject.todolist.ui;
import com.petproject.todolist.core.RemoveTaskService;
import com.petproject.todolist.core.ShowAllTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RemoveTaskUIAction implements UIAction {

    @Autowired
    private RemoveTaskService removeTaskService;
    @Autowired
    private ShowAllTaskService showAllTaskService;

    @Override
    public void execute() {

        System.out.println("\033[H\033[2J");
        System.out.flush();

        // Print data
        System.out.println("All Tasks what we have at this moment: ");
        var response = showAllTaskService.showAllToDo();
        System.out.println("******************************");
        System.out.println("Received response: " + response);
        System.out.println("______________________________");

        // Create scanner
        var scanner = new Scanner(System.in);

        // Asking user some data
        System.out.print("Please enter ID of the Task what you are should to remove: ");
        var id = Integer.parseInt(scanner.nextLine());

        // Use Service to remove the Task
        removeTaskService.removeToDo(id);

    }
}