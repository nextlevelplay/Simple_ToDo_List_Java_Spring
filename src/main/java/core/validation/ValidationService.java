package core.validation;

import domain.ToDoEntity;
import dto.CreateTaskRequest;

import java.util.ArrayList;
import java.util.List;

public class ValidationService {

    private final List<ValidationRule> validationRules;

    public ValidationService(List<ValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

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
