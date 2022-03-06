package core.validation;

import domain.ToDoEntity;
import dto.CreateTaskRequest;

public interface ValidationRule {

    void validate(CreateTaskRequest request);
}
