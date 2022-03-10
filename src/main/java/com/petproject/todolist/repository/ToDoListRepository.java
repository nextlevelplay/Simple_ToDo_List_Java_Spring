package com.petproject.todolist.repository;

import com.petproject.todolist.domain.ToDoEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ToDoListRepository implements ToDoRepository {

    private final List<ToDoEntity> repository = new ArrayList<>();
    private Integer idSequence = 1;


    // Create ToDo
    @Override
    public ToDoEntity createToDo(ToDoEntity entity) {
        entity.setId(idSequence);
        idSequence++;
        repository.add(entity);
        return entity;
    }

    // Show all ToDo's
    @Override
    public List<ToDoEntity> showAllToDo() {
        return repository;
    }

    @Override
    public ToDoEntity findById(Integer id) {
        for (ToDoEntity value : repository) {
            if (value != null && id.equals(value.getId())) {
                return value;
            }
        }
        return null;
    }


    // Update ToDo
    @Override
    public ToDoEntity updateToDo(ToDoEntity entity) {
        var updatedEntity = findById(entity.getId());
        for (ToDoEntity value : repository) {
            if (value != null && updatedEntity.getId().equals(value.getId())) {
                updatedEntity.setName(entity.getName());
                updatedEntity.setDescription(entity.getDescription());
            }
        }
        return entity;
    }

    // Remove ToDo
    @Override
    public boolean removeToDo(Integer id) {
        return repository.removeIf(entity -> entity.getId().equals(id));
    }

}
