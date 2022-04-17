package com.petproject.todolist.dto;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UpdateTaskResponse {

    private Integer id;
    private String name;
    private String description;
    private Integer userId;

}
