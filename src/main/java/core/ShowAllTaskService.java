package core;

import domain.ToDoEntity;
import repository.ToDoListRepository;

import java.util.List;

public class ShowAllTaskService {

    private ToDoListRepository repository;

    public ShowAllTaskService(ToDoListRepository repository) {
        this.repository = repository;
    }

    public List<ToDoEntity> showAllToDo(){
        return repository.showAllToDo();
    }
}
