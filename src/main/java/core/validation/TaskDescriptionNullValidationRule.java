package core.validation;

import domain.ToDoEntity;
import dto.CreateTaskRequest;

public class TaskDescriptionNullValidationRule implements ValidationRule{

    @Override
    public void validate(CreateTaskRequest request) {
        if (request.getDescription() == null) {
            throw new ValidationException("Task description can't be null!");
        }
    }
}
