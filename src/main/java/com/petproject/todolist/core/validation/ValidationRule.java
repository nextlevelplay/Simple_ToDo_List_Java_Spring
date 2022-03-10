package com.petproject.todolist.core.validation;

import com.petproject.todolist.dto.CreateTaskRequest;

public interface ValidationRule {

    void validate(CreateTaskRequest request);
}
