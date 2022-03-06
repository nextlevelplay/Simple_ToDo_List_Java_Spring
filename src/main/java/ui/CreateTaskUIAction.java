package ui;

import core.CreateTaskService;
import domain.ToDoEntity;

import java.util.Scanner;

public class CreateTaskUIAction implements UIAction{

    private CreateTaskService createTaskService;

    public CreateTaskUIAction(CreateTaskService createTaskService) {
        this.createTaskService = createTaskService;
    }

    @Override
    public void execute() {

        System.out.println("\033[H\033[2J");
        System.out.flush();

        // Create scanner
        var scanner = new Scanner(System.in);
        var entity = new ToDoEntity();

        // Asking user some data
        System.out.println("******************************");
        System.out.print("Please enter name of Task: ");
        entity.setName(scanner.nextLine());
        System.out.print("Please enter description: ");
        entity.setDescription(scanner.nextLine());

        // Use Service to create Task
        createTaskService.createToDo(entity);
    }
}
