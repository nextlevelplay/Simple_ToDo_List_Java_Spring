package com.petproject.todolist.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CreateTaskRequest {

    private String name;
    private String description;

}
