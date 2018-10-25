package com.skywalk.todo.application.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class TodoModel {
    private Long id;
    @NotNull
    @Size(min = 1, max = 100, message = "The todo name needs to be between 1 and 100 characters long")
    private String name;
    @NotNull(message = "Completed cannot be null")
    private boolean completed;
}
