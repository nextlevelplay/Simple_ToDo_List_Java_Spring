package com.petproject.todolist.core;

import com.petproject.todolist.domain.ToDoEntity;
import com.petproject.todolist.dto.TaskDTO;
import com.petproject.todolist.repository.ToDoRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateTaskService {

    private ToDoRepository repository;

    public UpdateTaskService(ToDoRepository repository) {
        this.repository = repository;
    }

    public TaskDTO updateToDo(ToDoEntity entity, String newName, String newDescription) {
        var updatedEntity = repository.updateToDo(entity, newName, newDescription);
        var response = convert(updatedEntity);
        return response;


    }

    private TaskDTO convert(ToDoEntity entity) {
        var dto = new TaskDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}
