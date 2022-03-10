package com.petproject.todolist.repository;

import com.petproject.todolist.domain.ToDoEntity;

import java.util.List;

public interface ToDoRepository {

    ToDoEntity createToDo(ToDoEntity entity);
    List<ToDoEntity> showAllToDo();
    ToDoEntity updateToDo(ToDoEntity entity);
    boolean removeToDo(Integer id);
    ToDoEntity findById(Integer id);

}
