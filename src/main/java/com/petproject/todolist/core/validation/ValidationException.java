package com.petproject.todolist.core.validation;

public class ValidationException extends RuntimeException{

    public ValidationException(String message) {
        super(message);
    }
}
