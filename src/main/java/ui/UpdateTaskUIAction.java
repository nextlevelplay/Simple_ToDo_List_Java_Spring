package ui;

import core.RemoveTaskService;
import core.ShowAllTaskService;
import core.UpdateTaskService;
import repository.ToDoRepository;

import java.util.Scanner;

public class UpdateTaskUIAction implements UIAction {

    //FIX THIS DEPENDENCY WITH SERVICE!!!
    private ToDoRepository repository;

    private ShowAllTaskService showAllTaskService;
    private UpdateTaskService updateTaskService;

    public UpdateTaskUIAction(ToDoRepository repository, ShowAllTaskService showAllTaskService, UpdateTaskService updateTaskService) {
        this.repository = repository;
        this.showAllTaskService = showAllTaskService;
        this.updateTaskService = updateTaskService;
    }

    @Override
    public void execute() {

        System.out.println("\033[H\033[2J");
        System.out.flush();

        // Print data
        System.out.println("All Tasks what we have at this moment: ");
        showAllTaskService.showAllToDo().forEach(System.out::println);
        System.out.println("******************************");

        // Create scanner
        var scanner = new Scanner(System.in);

        // Asking user some data
        System.out.print("Please enter ID of the Task what you are should to update: ");
        var id = Integer.parseInt(scanner.nextLine());
        System.out.println("******************************");
        System.out.print("Type new name: ");
        var newName = scanner.nextLine();
        System.out.print("Type new description: ");
        var newDescription = scanner.nextLine();

        // Find a Task by ID
        var entity = repository.findById(id);

        // Use Service to update the Task
        updateTaskService.updateToDo(entity,newName,newDescription);
    }
}

