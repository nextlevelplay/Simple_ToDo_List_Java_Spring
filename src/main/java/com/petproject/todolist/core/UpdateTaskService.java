package com.petproject.todolist.core;

import com.petproject.todolist.domain.ToDoEntity;
import com.petproject.todolist.dto.TaskDTO;
import com.petproject.todolist.dto.UpdateTaskRequest;
import com.petproject.todolist.dto.UpdateTaskResponse;
import com.petproject.todolist.repository.ToDoRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateTaskService {

    private ToDoRepository repository;

    public UpdateTaskService(ToDoRepository repository) {
        this.repository = repository;
    }

    public UpdateTaskResponse updateToDo(UpdateTaskRequest request) {
        var entity = convert(request);
        var updatedEntity = repository.updateToDo(entity);
        System.out.println("******************************");
        System.out.println("Successfully updated " + updatedEntity);
        var response = new UpdateTaskResponse();
        response.setId(updatedEntity.getId());
        response.setName(updatedEntity.getName());
        response.setDescription(updatedEntity.getDescription());
        System.out.println("******************************");
        System.out.println("Sending response: " + response);
        return response;


    }

    private ToDoEntity convert(UpdateTaskRequest request) {
        var entity = new ToDoEntity();
        entity.setId(request.getId());
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        return entity;
    }
}
