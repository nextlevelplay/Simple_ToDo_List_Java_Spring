package core.validation;

import domain.ToDoEntity;
import dto.CreateTaskRequest;

public class TaskNameMaxLengthValidationRule implements ValidationRule {

    @Override
    public void validate(CreateTaskRequest request) {
        if (request.getName().length() > 20) {
            throw new ValidationException("Task name must not exceed 20 symbols! Actual length is: "
                    + request.getName().length());
        }

    }
}
