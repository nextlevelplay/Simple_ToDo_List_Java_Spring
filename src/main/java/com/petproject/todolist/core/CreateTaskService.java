package com.petproject.todolist.core;
import com.petproject.todolist.core.validation.ValidationService;
import com.petproject.todolist.domain.ToDoEntity;
import com.petproject.todolist.domain.UserEntity;
import com.petproject.todolist.dto.CreateTaskRequest;
import com.petproject.todolist.dto.CreateTaskResponse;
import com.petproject.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskService {

    @Autowired
    private ToDoRepository<ToDoEntity> taskRepository;

    @Autowired
    private ToDoRepository<UserEntity> userRepository;

    @Autowired
    private ValidationService validationService;

    public CreateTaskResponse createToDo(CreateTaskRequest request) {
        System.out.println("******************************");
        System.out.println("Received request: " + request);
        var validationResult = validationService.validate(request);
        if (!validationResult.isEmpty()) {
            System.out.println("******************************");
            System.out.println("Validation failed, errors: " + validationResult);
            var response = new CreateTaskResponse();
            response.setErrors(validationResult);
            return response;
        }
        var entity = convert(request);
        entity.setUserId(request.getUserId());
        var createdEntity = taskRepository.create(entity);
        System.out.println("******************************");
        System.out.println("Successfully created " + createdEntity);
        var response = new CreateTaskResponse();
        response.setId(createdEntity.getId());
        System.out.println("******************************");
        System.out.println("Sending response: " +response);
        return response;
    }

    private ToDoEntity convert(CreateTaskRequest request){
        var entity = new ToDoEntity();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        return entity;
    }
}
