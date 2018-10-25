package com.skywalk.todo.common.factories;

import com.skywalk.todo.application.model.NewTodoModel;
import com.skywalk.todo.application.model.TodoModel;
import com.skywalk.todo.domain.model.Todo;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Log
public class TodoFactory {

    private final ModelMapper modelMapper;

    public Todo buildNewTodo(final NewTodoModel newTodoModel) {
        log.info("Started buildNewTodo() in TodoFactory at : " + System.currentTimeMillis());
        final Todo todo = modelMapper.map(newTodoModel, Todo.class);
        log.info("Completed buildNewTodo() in TodoFactory at : " + System.currentTimeMillis());
        return todo;
    }

    public Todo buildTodo(final TodoModel todoModel) {
        log.info("Started buildTodo() in TodoFactory at : " + System.currentTimeMillis());
        final Todo todo = modelMapper.map(todoModel, Todo.class);
        log.info("Completed buildTodo() in TodoFactory at : " + System.currentTimeMillis());
        return todo;
    }

    public TodoModel buildTodoModel(final Todo todo) {
        log.info("Started buildTodoModel() in TodoFactory at : " + System.currentTimeMillis());
        final TodoModel todoModel = modelMapper.map(todo, TodoModel.class);
        log.info("Completed buildTodoModel() in TodoFactory at : " + System.currentTimeMillis());
        return todoModel;
    }
}
