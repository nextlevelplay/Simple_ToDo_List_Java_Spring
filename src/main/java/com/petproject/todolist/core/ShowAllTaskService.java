package com.petproject.todolist.core;

import com.petproject.todolist.domain.ToDoEntity;
import com.petproject.todolist.dto.ShowAllTaskResponse;
import com.petproject.todolist.dto.TaskDTO;
import com.petproject.todolist.repository.ToDoListRepository;
import org.springframework.stereotype.Service;

@Service
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
