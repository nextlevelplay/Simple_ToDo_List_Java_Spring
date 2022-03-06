package ui;

import core.ShowAllTaskService;

public class ShowAllTaskUIAction implements UIAction{

    private ShowAllTaskService showAllTaskService;

    public ShowAllTaskUIAction(ShowAllTaskService showAllTaskService) {
        this.showAllTaskService = showAllTaskService;
    }

    @Override
    public void execute() {

        System.out.println("\033[H\033[2J");
        System.out.flush();

        // Print data
        System.out.println("All Tasks what we have at this moment: ");
        showAllTaskService.showAllToDo().forEach(System.out::println);
        System.out.println("******************************");


    }
}
