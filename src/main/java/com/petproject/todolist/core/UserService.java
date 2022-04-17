package com.petproject.todolist.core;

import com.petproject.todolist.domain.UserEntity;
import com.petproject.todolist.dto.CreateUserRequest;
import com.petproject.todolist.dto.CreateUserResponse;
import com.petproject.todolist.repository.ToDoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private final ToDoRepository<UserEntity> repository;

    public CreateUserResponse createUser(CreateUserRequest request) {
        var entity = convert(request);
        repository.create(entity);
        var response = new CreateUserResponse();
        response.setCreatedUserId(entity.getId());
        return response;
    }

    private UserEntity convert(CreateUserRequest request) {
        var entity = new UserEntity();
        entity.setUserName(request.getUserName());
        return entity;
    }

}
