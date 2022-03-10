package core;

import domain.ToDoEntity;
import dto.ShowAllTaskResponse;
import dto.TaskDTO;
import repository.ToDoListRepository;

import java.util.List;

public class ShowAllTaskService {

    private ToDoListRepository repository;

    public ShowAllTaskService(ToDoListRepository repository) {
        this.repository = repository;
    }

    public ShowAllTaskResponse showAllToDo(){
        var dtos = repository.showAllToDo().stream()
                .map(this::convert)
                .toList();
        return new ShowAllTaskResponse(dtos);

    }

    private TaskDTO convert(ToDoEntity entity){
        return new TaskDTO(entity.getId(),entity.getName(),entity.getDescription());
    }
}
