package com.petproject.todolist.core;
import com.petproject.todolist.domain.ToDoEntity;
import com.petproject.todolist.dto.UpdateTaskRequest;
import com.petproject.todolist.dto.UpdateTaskResponse;
import com.petproject.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateTaskService {

    @Autowired
    private ToDoRepository<ToDoEntity> repository;

    public UpdateTaskResponse updateToDo(UpdateTaskRequest request) {
        var entity = convert(request);
        var updatedEntity = repository.update(entity);
        System.out.println("******************************");
        System.out.println("Successfully updated " + updatedEntity);
        var response = new UpdateTaskResponse();
        response.setId(updatedEntity.getId());
        response.setName(updatedEntity.getName());
        response.setDescription(updatedEntity.getDescription());
        response.setUserId(updatedEntity.getUserId());
        System.out.println("******************************");
        System.out.println("Sending response: " + response);
        return response;


    }

    private ToDoEntity convert(UpdateTaskRequest request) {
        var entity = new ToDoEntity();
        entity.setId(request.getId());
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setUserId(request.getUserId());
        return entity;
    }
}
