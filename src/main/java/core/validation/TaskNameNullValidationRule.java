package core.validation;

import domain.ToDoEntity;
import dto.CreateTaskRequest;

public class TaskNameNullValidationRule implements ValidationRule {

    @Override
    public void validate(CreateTaskRequest request) {
        if (request.getName() == null) {
            throw new ValidationException("Task name can't be null!");
        }
    }
}
