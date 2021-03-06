package com.petproject.todolist.ui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class MainMenu implements UIAction {

    // UI Dependency
    @Autowired
    CreateUserUIAction createUserUIAction;
    @Autowired
    CreateTaskUIAction createTaskUIAction;
    @Autowired
    ShowAllTaskUIAction showAllTaskUIAction;
    @Autowired
    RemoveTaskUIAction removeTaskUIAction;
    @Autowired
    UpdateTaskUIAction updateTaskUIAction;


    @Override
    public void execute() {

        var scanner = new Scanner(System.in);


        while (true) {
            try {
                System.out.println("       █████                                    ███████████                   █████         █████        ███           █████   \n" +
                        "      ░░███                                    ░█░░░███░░░█                  ░░███         ░░███        ░░░           ░░███    \n" +
                        "       ░███   ██████   █████ █████  ██████     ░   ░███  ░   ██████    █████  ░███ █████    ░███        ████   █████  ███████  \n" +
                        "       ░███  ░░░░░███ ░░███ ░░███  ░░░░░███        ░███     ░░░░░███  ███░░   ░███░░███     ░███       ░░███  ███░░  ░░░███░   \n" +
                        "       ░███   ███████  ░███  ░███   ███████        ░███      ███████ ░░█████  ░██████░      ░███        ░███ ░░█████   ░███    \n" +
                        " ███   ░███  ███░░███  ░░███ ███   ███░░███        ░███     ███░░███  ░░░░███ ░███░░███     ░███      █ ░███  ░░░░███  ░███ ███\n" +
                        "░░████████  ░░████████  ░░█████   ░░████████       █████   ░░████████ ██████  ████ █████    ███████████ █████ ██████   ░░█████ \n" +
                        " ░░░░░░░░    ░░░░░░░░    ░░░░░     ░░░░░░░░       ░░░░░     ░░░░░░░░ ░░░░░░  ░░░░ ░░░░░    ░░░░░░░░░░░ ░░░░░ ░░░░░░     ░░░░░  \n" +
                        "                                                                                                                               \n" +
                        "                                                    Console Task manager Beta 1.0                                              \n" +
                        "                                                                                                                               ");
                System.out.println("\033[H\033[2J");
                System.out.flush();

                System.out.println("1) Create User.");
                System.out.println("2) Create Task.");
                System.out.println("3) Update Task.");
                System.out.println("4) Show all Tasks.");
                System.out.println("5) Remove the Task.");
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
                    createUserUIAction.execute();
                    break;
                case 2:
                    createTaskUIAction.execute();
                    break;
                case 3:
                    updateTaskUIAction.execute();
                    break;
                case 4:
                    showAllTaskUIAction.execute();
                    break;
                case 5:
                    removeTaskUIAction.execute();
                    break;
            }
        } else {
            System.out.println("Please select actions from the list, not like you: " + selector);
        }
    }
}

