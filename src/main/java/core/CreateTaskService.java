package core;

import domain.ToDoEntity;
import repository.ToDoListRepository;

public class CreateTaskService {

    private ToDoListRepository repository;

    public CreateTaskService(ToDoListRepository repository) {
        this.repository = repository;
    }

    public void createToDo(ToDoEntity entity){
        repository.createToDo(entity);
        System.out.println("******************************");
        System.out.println("Task successfully create!");
    }
}
