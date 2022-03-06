package dto;

import core.validation.CoreError;

import java.util.List;
import java.util.Objects;

public class CreateTaskResponse {

    private Integer id;
    private List<CoreError> errors;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CoreError> getErrors() {
        return errors;
    }

    public void setErrors(List<CoreError> errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateTaskResponse that = (CreateTaskResponse) o;
        return Objects.equals(id, that.id) && Objects.equals(errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, errors);
    }

    @Override
    public String toString() {
        return "CreateTaskResponse{" +
                "id=" + id +
                ", errors=" + errors +
                '}';
    }
}
