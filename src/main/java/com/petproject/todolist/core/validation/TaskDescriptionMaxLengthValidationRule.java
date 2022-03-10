package com.petproject.todolist.core.validation;

import com.petproject.todolist.dto.CreateTaskRequest;
import org.springframework.stereotype.Component;

@Component
public class TaskDescriptionMaxLengthValidationRule implements ValidationRule {

    @Override
    public void validate(CreateTaskRequest request) {
        if (request.getDescription().length() > 50) {
            throw new ValidationException("Task description must not exceed 50 symbols! Actual length is: "
                    + request.getDescription().length());
        }
    }
}
