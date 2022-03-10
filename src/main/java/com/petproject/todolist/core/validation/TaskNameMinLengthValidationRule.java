package com.petproject.todolist.core.validation;

import com.petproject.todolist.dto.CreateTaskRequest;
import org.springframework.stereotype.Component;

@Component
public class TaskNameMinLengthValidationRule implements ValidationRule {

    @Override
    public void validate(CreateTaskRequest request) {
        if (request.getName().length() < 1) {
            throw new ValidationException("Task name must be longer than 1 symbol! Actual length is: "
                    + request.getName().length());
        }
    }
}
