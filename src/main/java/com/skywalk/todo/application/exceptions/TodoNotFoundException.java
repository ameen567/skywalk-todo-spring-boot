package com.skywalk.todo.application.exceptions;

public class TodoNotFoundException extends BusinessException {
    public TodoNotFoundException(String message) {
        super(message, true);
    }
}
