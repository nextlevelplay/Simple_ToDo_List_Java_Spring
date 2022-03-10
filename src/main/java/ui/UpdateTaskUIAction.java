package ui;

import core.FindByIdTaskService;
import core.ShowAllTaskService;
import core.UpdateTaskService;

import java.util.Scanner;

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


        // Use Service to update the Task
        var response = updateTaskService.updateToDo(entity,newName,newDescription);
        System.out.println("******************************");
        System.out.println("Received response: " + response);
    }
}

