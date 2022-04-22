package com.petproject.todolist.repository;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository<T> {

    T create(T entity);
    List<T> showAll();
    T update(T entity);
    boolean remove(Integer id);
    Optional<T> findById(Integer id);

}
