package com.petproject.todolist.core;
import com.petproject.todolist.domain.ToDoEntity;
import com.petproject.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveTaskService {

    @Autowired
    private ToDoRepository<ToDoEntity> repository;

    public void removeToDo(Integer id){
        var result = repository.remove(id);
        if (result){
            System.out.println("******************************");
            System.out.println("Sending response: Task removed!");
        } else {
            System.out.println("******************************");
            System.out.println("Sending response: Wrong ID number!");
        }
    }
}
