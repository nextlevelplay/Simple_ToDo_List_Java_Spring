package com.petproject.todolist.core.validation;

import com.petproject.todolist.dto.CreateTaskRequest;
import org.springframework.stereotype.Component;

@Component
public class TaskDescriptionMinLengthValidationRule implements ValidationRule {

    @Override
    public void validate(CreateTaskRequest request) {
        if (request.getDescription().length() < 3) {
            throw new ValidationException("Task description must be longer than 3 symbol! Actual length is: "
                    + request.getDescription().length());
        }
    }
}
