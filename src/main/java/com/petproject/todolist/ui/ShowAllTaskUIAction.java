package com.petproject.todolist.ui;
import com.petproject.todolist.core.ShowAllTaskService;
import com.petproject.todolist.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
        var response = showAllTaskService.showAll();
        response.getTasks().forEach(System.out::println);
        System.out.println("______________________________");


    }
}
