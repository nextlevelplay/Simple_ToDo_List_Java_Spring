package core.validation;

import domain.ToDoEntity;
import dto.CreateTaskRequest;

public class TaskNameMinLengthValidationRule implements ValidationRule {

    @Override
    public void validate(CreateTaskRequest request) {
        if (request.getName().length() < 1) {
            throw new ValidationException("Task name must be longer than 1 symbol! Actual length is: "
                    + request.getName().length());
        }
    }
}
