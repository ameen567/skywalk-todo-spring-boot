package com.skywalk.todo.application.services.impl;

import com.skywalk.todo.application.exceptions.TodoNotFoundException;
import com.skywalk.todo.application.model.NewTodoModel;
import com.skywalk.todo.application.model.TodoModel;
import com.skywalk.todo.application.services.TodoService;
import com.skywalk.todo.domain.factories.TodoFactory;
import com.skywalk.todo.domain.model.Todo;
import com.skywalk.todo.domain.repository.TodoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Log
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final TodoFactory todoFactory;

    @Override
    public void createTodo(final NewTodoModel newTodoModel) {
        log.info("Started createTodo() in TodoServiceImpl at : " + System.currentTimeMillis());
        final Todo newTodo = todoFactory.buildNewTodo(newTodoModel);
        todoRepository.save(newTodo);
        log.info("Completed createTodo() in TodoServiceImpl at : " + System.currentTimeMillis());
    }

    @Override
    public void deleteTodo(final Long id) {
        log.info("Started deleteTodo() in TodoServiceImpl at : " + System.currentTimeMillis());
        final Todo todoToDelete = findTodoById(id);
        todoRepository.delete(todoToDelete);
        log.info("Completed deleteTodo() in TodoServiceImpl at : " + System.currentTimeMillis());
    }

    @Override
    public void updateTodo(final TodoModel todoModel) {
        log.info("Started updateTodo() in TodoServiceImpl at : " + System.currentTimeMillis());
        final Todo todo = findTodoById(todoModel.getId());
        final Todo todoToUpdate = todoFactory.buildTodo(todoModel);
        todoRepository.save(todoToUpdate);
        log.info("Completed updateTodo() in TodoServiceImpl at : " + System.currentTimeMillis());
    }

    @Override
    public TodoModel getOneTodo(final Long id) {
        log.info("Started getOneTodo() in TodoServiceImpl at : " + System.currentTimeMillis());
        final Todo todo = findTodoById(id);
        log.info("Completed getOneTodo() in TodoServiceImpl at : " + System.currentTimeMillis());
        return todoFactory.buildTodoModel(todo);
    }

    @Override
    public List<TodoModel> getAllTodos() {
        log.info("Started getAllTodos() in TodoServiceImpl at : " + System.currentTimeMillis());
        return todoRepository.findAll()
                .stream()
                .map(todoFactory::buildTodoModel)
                .collect(Collectors.toList());
    }

    private Todo findTodoById(final Long id) {
        log.info("Started findTodoById() in TodoServiceImpl at : " + System.currentTimeMillis());
        final Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (!optionalTodo.isPresent()) {
            log.severe("The Todo with id " + id + "does not exist");
            throw new TodoNotFoundException("The Todo does not exist");
        }
        log.info("Completed findTodoById() in TodoServiceImpl at : " + System.currentTimeMillis());
        return optionalTodo.get();
    }
}
