package com.petproject.todolist.core;
import com.petproject.todolist.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveTaskService {

    @Autowired
    private ToDoListRepository repository;

    public void removeToDo(Integer id){
        var result = repository.removeToDo(id);
        if (result){
            System.out.println("******************************");
            System.out.println("Sending response: Task removed!");
        } else {
            System.out.println("******************************");
            System.out.println("Sending response: Wrong ID number!");
        }
    }
}
