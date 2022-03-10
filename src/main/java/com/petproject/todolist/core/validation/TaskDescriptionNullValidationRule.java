package com.petproject.todolist.core.validation;

import com.petproject.todolist.dto.CreateTaskRequest;
import org.springframework.stereotype.Component;

@Component
public class TaskDescriptionNullValidationRule implements ValidationRule{

    @Override
    public void validate(CreateTaskRequest request) {
        if (request.getDescription() == null) {
            throw new ValidationException("Task description can't be null!");
        }
    }
}
