package dto;

import lombok.Data;

@Data
public class CreateTaskRequest {

    private String name;
    private String description;

}
