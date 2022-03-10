package core;

import domain.ToDoEntity;
import repository.ToDoListRepository;

public class FindByIdTaskService {

    private ToDoListRepository repository;

    public FindByIdTaskService(ToDoListRepository repository) {
        this.repository = repository;
    }

    public ToDoEntity findById(Integer id) {
        var entity = repository.findById(id);
        return entity;
    }
}
