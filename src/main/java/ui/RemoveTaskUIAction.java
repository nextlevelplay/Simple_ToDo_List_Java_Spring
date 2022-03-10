package ui;

import core.RemoveTaskService;
import core.ShowAllTaskService;

import java.util.Scanner;

public class RemoveTaskUIAction implements UIAction {

    private RemoveTaskService removeTaskService;
    private ShowAllTaskService showAllTaskService;

    public RemoveTaskUIAction(RemoveTaskService removeTaskService, ShowAllTaskService showAllTaskService) {
        this.removeTaskService = removeTaskService;
        this.showAllTaskService = showAllTaskService;
    }

    @Override
    public void execute() {

        System.out.println("\033[H\033[2J");
        System.out.flush();

        // Print data
        System.out.println("All Tasks what we have at this moment: ");
        var response = showAllTaskService.showAllToDo();
        System.out.println("******************************");
        System.out.println(response);

        // Create scanner
        var scanner = new Scanner(System.in);

        // Asking user some data
        System.out.print("Please enter ID of the Task what you are should to remove: ");
        var id = Integer.parseInt(scanner.nextLine());

        // Use Service to remove the Task
        var result = removeTaskService.removeToDo(id);
        if (result == true){
            System.out.println("******************************");
            System.out.println("Task removed!");
        } else {
            System.out.println("******************************");
            System.out.println("Wrong ID number!");
        }

    }
}