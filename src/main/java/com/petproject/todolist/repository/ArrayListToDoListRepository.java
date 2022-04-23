package com.petproject.todolist.repository;

import com.petproject.todolist.domain.ToDoEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class ArrayListToDoListRepository implements ToDoRepository<ToDoEntity> {

    private final List<ToDoEntity> repository = new ArrayList<>();
    private Integer idSequence = 1;


    // Create ToDo
    @Override
    public ToDoEntity create(ToDoEntity entity) {
        entity.setId(idSequence);
        idSequence++;
        repository.add(entity);
        return entity;
    }

    // Show all ToDo's
    @Override
    public List<ToDoEntity> showAll() {
        return repository;
    }

    @Override
    public Optional<ToDoEntity> findById(Integer id) {
        return null;
    }


    // Update ToDo
    @Override
    public ToDoEntity update(ToDoEntity entity) {
        return null;
    }

    // Remove ToDo
    @Override
    public boolean remove(Integer id) {
        return repository.removeIf(entity -> entity.getId().equals(id));
    }

}
