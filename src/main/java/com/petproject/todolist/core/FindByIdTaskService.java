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
        var entity = repository.findById(id);
        return new FindByIdTaskResponse(convert(entity));


    }

    private TaskDTO convert(ToDoEntity entity) {
        return new TaskDTO(entity.getId(), entity.getName(), entity.getDescription(),entity.getUserId());
    }
}
