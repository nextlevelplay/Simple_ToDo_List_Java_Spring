package com.petproject.todolist.core.validation;

import com.petproject.todolist.dto.CreateTaskRequest;
import org.springframework.stereotype.Component;

@Component
public class TaskNameNullValidationRule implements ValidationRule {

    @Override
    public void validate(CreateTaskRequest request) {
        if (request.getName() == null) {
            throw new ValidationException("Task name can't be null!");
        }
    }
}
