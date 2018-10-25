package com.skywalk.todo.application.services;

import com.skywalk.todo.application.model.NewTodoModel;
import com.skywalk.todo.application.model.TodoModel;

import java.util.List;

public interface TodoService {
    void createTodo(final NewTodoModel newTodoModel);

    void deleteTodo(final Long id);

    void updateTodo(final TodoModel todoModel);

    TodoModel getOneTodo(final Long id);

    List<TodoModel> getAllTodos();
}
