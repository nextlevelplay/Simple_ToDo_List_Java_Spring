package com.petproject.todolist.core;
import com.petproject.todolist.domain.ToDoEntity;
import com.petproject.todolist.dto.ShowAllTaskResponse;
import com.petproject.todolist.dto.TaskDTO;
import com.petproject.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowAllTaskService {

    @Autowired
    private ToDoRepository<ToDoEntity> repository;

    public ShowAllTaskResponse showAll(){
        var dtos = repository.showAll().stream()
                .map(this::convert)
                .toList();
        return new ShowAllTaskResponse(dtos);

    }

    private TaskDTO convert(ToDoEntity entity){
        return new TaskDTO(entity.getId(),entity.getName(),entity.getDescription(),entity.getUserId());
    }
}
