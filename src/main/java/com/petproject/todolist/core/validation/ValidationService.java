package com.petproject.todolist.core.validation;
import com.petproject.todolist.dto.CreateTaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValidationService {

    @Autowired
    private List<ValidationRule> validationRules;

    public List<CoreError> validate(CreateTaskRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (request == null) {
            errors.add(new CoreError("Task can't be null!"));
            return errors;
        }
        validationRules.forEach(validationRule -> {
            try {
                validationRule.validate(request);
            } catch (ValidationException e) {
                errors.add(new CoreError(e.getMessage()));
            }
        });
        return errors;
    }
}
