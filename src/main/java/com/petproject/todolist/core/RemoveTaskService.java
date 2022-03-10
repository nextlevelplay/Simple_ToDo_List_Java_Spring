package com.petproject.todolist.core;

import com.petproject.todolist.repository.ToDoListRepository;
import org.springframework.stereotype.Service;

@Service
public class RemoveTaskService {

    private ToDoListRepository repository;

    public RemoveTaskService(ToDoListRepository repository) {
        this.repository = repository;
    }

    public boolean removeToDo(Integer id){
        return repository.removeToDo(id);
    }
}
