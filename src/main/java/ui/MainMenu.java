package ui;

import core.CreateTaskService;
import core.RemoveTaskService;
import core.ShowAllTaskService;
import core.UpdateTaskService;
import core.validation.*;
import repository.ToDoListRepository;

import java.util.List;
import java.util.Scanner;

public class MainMenu implements UIAction {

    // Repository
    ToDoListRepository repository = new ToDoListRepository();

    // Validation Rules
    List<ValidationRule> validationRules = List.of(
            new TaskNameNullValidationRule(),
            new TaskNameMinLengthValidationRule(),
            new TaskNameMaxLengthValidationRule(),
            new TaskDescriptionNullValidationRule(),
            new TaskDescriptionMinLengthValidationRule(),
            new TaskDescriptionMaxLengthValidationRule()
    );


    // Service Dependency
    ValidationService validationService = new ValidationService(validationRules);
    CreateTaskService createTaskService = new CreateTaskService(repository,validationService);
    ShowAllTaskService showAllTaskService = new ShowAllTaskService(repository);
    RemoveTaskService removeTaskService = new RemoveTaskService(repository);
    UpdateTaskService updateTaskService = new UpdateTaskService(repository);

    // UI Dependency
    CreateTaskUIAction createTaskUIAction = new CreateTaskUIAction(createTaskService);
    ShowAllTaskUIAction showAllTaskUIAction = new ShowAllTaskUIAction(showAllTaskService);
    RemoveTaskUIAction removeTaskUIAction = new RemoveTaskUIAction(removeTaskService,showAllTaskService);
    UpdateTaskUIAction updateTaskUIAction = new UpdateTaskUIAction(repository,showAllTaskService,updateTaskService);


    @Override
    public void execute() {

        var scanner = new Scanner(System.in);


        while (true) {
            try {
            System.out.println("\033[H\033[2J");
            System.out.flush();

            System.out.println("1) Create Task.");
            System.out.println("2) Update Task.");
            System.out.println("3) Show all Tasks.");
            System.out.println("4) Remove the Task.");
            System.out.println("0) Exit.");
            System.out.print("Please make a choice: ");

            int selector = Integer.parseInt(scanner.nextLine());

            if (selector == 0) {
                System.out.println("**************************************");
                System.out.println("Have a nice day! Comeback later!");
                break;
            } else {
                executeUIAction(selector);
            }
        } catch (Exception e) {
            e.printStackTrace();
            }
        }
    }

    private void executeUIAction(int selector) {
        if (selector != 0) {
            switch (selector) {
                case 1:
                    createTaskUIAction.execute();
                    break;
                case 2:
                    updateTaskUIAction.execute();
                    break;
                case 3:
                    showAllTaskUIAction.execute();
                    break;
                case 4:
                    removeTaskUIAction.execute();
                    break;
            }
        } else {
            System.out.println("Please select actions from the list, not like you: " + selector);
        }
    }
}

