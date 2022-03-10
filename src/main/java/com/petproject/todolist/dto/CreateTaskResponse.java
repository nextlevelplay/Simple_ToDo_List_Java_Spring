package com.petproject.todolist.dto;

import com.petproject.todolist.core.validation.CoreError;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class CreateTaskResponse {

    private Integer id;
    private List<CoreError> errors;

}
