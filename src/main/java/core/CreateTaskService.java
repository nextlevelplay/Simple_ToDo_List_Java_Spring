package core;

import core.validation.ValidationService;
import domain.ToDoEntity;
import dto.CreateTaskRequest;
import dto.CreateTaskResponse;
import repository.ToDoListRepository;

public class CreateTaskService {


    private ToDoListRepository repository;
    private ValidationService validationService;

    public CreateTaskService(ToDoListRepository repository, ValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

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
        var createdEntity = repository.createToDo(entity);
        System.out.println("******************************");
        System.out.println("Successfully created " + createdEntity);
        var response = new CreateTaskResponse();
        response.setId(createdEntity.getId());
        System.out.println("******************************");
        System.out.println("Sending response: " +response);
        return response;
    }

    private ToDoEntity convert(CreateTaskRequest request){
        ToDoEntity entity = new ToDoEntity();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        return entity;
    }
}