package com.petproject.todolist.core;
import com.petproject.todolist.domain.ToDoEntity;
import com.petproject.todolist.dto.FindByIdTaskResponse;
import com.petproject.todolist.dto.TaskDTO;
import com.petproject.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindByIdTaskService {

    @Autowired
    private ToDoRepository<ToDoEntity> repository;

    public FindByIdTaskResponse findById(Integer id) {
        return repository.findById(id)
                .map(this::convert)
                .map(FindByIdTaskResponse::new)
                .orElseThrow(() -> new IllegalArgumentException("ToDo with id " + id + " is not found."));
    }

    private TaskDTO convert(ToDoEntity entity) {
        return new TaskDTO(entity.getId(), entity.getName(), entity.getDescription());

    }
}
