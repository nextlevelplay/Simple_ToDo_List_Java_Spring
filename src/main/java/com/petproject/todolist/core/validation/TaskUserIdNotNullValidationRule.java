package com.petproject.todolist.core.validation;

import com.petproject.todolist.dto.CreateTaskRequest;
import org.springframework.stereotype.Component;

@Component
public class TaskUserIdNotNullValidationRule implements ValidationRule{
    @Override
    public void validate(CreateTaskRequest request) {
        if (request.getUserId() == null) {
            throw new ValidationException("User ID can't be null!");
        }
    }
}
