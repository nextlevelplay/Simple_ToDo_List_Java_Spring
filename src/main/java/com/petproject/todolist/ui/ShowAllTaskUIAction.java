package com.petproject.todolist.ui;
import com.petproject.todolist.core.ShowAllTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShowAllTaskUIAction implements UIAction {

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


    }
}
