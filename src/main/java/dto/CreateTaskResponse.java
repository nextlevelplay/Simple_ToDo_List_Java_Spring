package dto;

import core.validation.CoreError;
import lombok.Data;

import java.util.List;

@Data
public class CreateTaskResponse {

    private Integer id;
    private List<CoreError> errors;

}
