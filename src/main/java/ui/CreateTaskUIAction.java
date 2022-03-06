package ui;

import core.CreateTaskService;
import domain.ToDoEntity;
import dto.CreateTaskRequest;

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
        var request = new CreateTaskRequest();

        // Asking user some data
        System.out.println("******************************");
        System.out.print("Please enter name of Task: ");
        request.setName(scanner.nextLine());
        System.out.print("Please enter description: ");
        request.setDescription(scanner.nextLine());

        // Use Service to create Task
        var response = createTaskService.createToDo(request);
        System.out.println("******************************");
        System.out.println("Received response: " + response);
    }
}
