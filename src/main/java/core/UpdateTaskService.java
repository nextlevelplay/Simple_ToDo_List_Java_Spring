package core;

import domain.ToDoEntity;
import repository.ToDoRepository;

public class UpdateTaskService {

    private ToDoRepository repository;

    public UpdateTaskService(ToDoRepository repository) {
        this.repository = repository;
    }

    public ToDoEntity updateToDo(ToDoEntity entity, String newName, String newDescription){
        return repository.updateToDo(entity,newName,newDescription);
    }
}
