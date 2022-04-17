package com.petproject.todolist.dto;

import com.petproject.todolist.core.validation.CoreError;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class CreateUserResponse {

    private Integer createdUserId;
    private List<CoreError> errors;
}
