package com.petproject.todolist.core;
import com.petproject.todolist.domain.ToDoEntity;
import com.petproject.todolist.repository.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindByIdTaskService {

    @Autowired
    private ToDoListRepository repository;

    public ToDoEntity findById(Integer id) {
        var entity = repository.findById(id);
        return entity;
    }
}
