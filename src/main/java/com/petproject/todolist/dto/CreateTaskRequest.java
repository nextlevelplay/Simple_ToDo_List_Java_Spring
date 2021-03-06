package com.petproject.todolist.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CreateTaskRequest {

    private String name;
    private String description;
    private Integer userId;

}
