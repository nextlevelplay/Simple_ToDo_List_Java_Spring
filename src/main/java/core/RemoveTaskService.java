package core;

import repository.ToDoListRepository;

public class RemoveTaskService {

    private ToDoListRepository repository;

    public RemoveTaskService(ToDoListRepository repository) {
        this.repository = repository;
    }

    public boolean removeToDo(Integer id){
        return repository.removeToDo(id);
    }
}
