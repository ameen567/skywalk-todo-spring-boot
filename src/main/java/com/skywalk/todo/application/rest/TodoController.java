package com.skywalk.todo.application.rest;

import com.skywalk.todo.application.model.NewTodoModel;
import com.skywalk.todo.application.model.TodoModel;
import com.skywalk.todo.application.services.TodoService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/todo", produces = MediaType.APPLICATION_JSON_VALUE)
@Log
@AllArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping(value = "/")
    public ResponseEntity createNewTodo(@RequestBody @Valid final NewTodoModel newTodoModel) {
        log.info("Started createNewTodo in TodoController at : " + System.currentTimeMillis());
        todoService.createTodo(newTodoModel);
        log.info("Completed createNewTodo in TodoController at : " + System.currentTimeMillis());
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(value = "/")
    public ResponseEntity updateTodo(@RequestBody @Valid final TodoModel todoModel) {
        log.info("Started updateTodo in TodoController at : " + System.currentTimeMillis());
        todoService.updateTodo(todoModel);
        log.info("Completed updateTodo in TodoController at : " + System.currentTimeMillis());
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{todoId}")
    public ResponseEntity deleteTodo(@PathVariable final Long todoId) {
        log.info("Started deleteTodo in TodoController at : " + System.currentTimeMillis());
        todoService.deleteTodo(todoId);
        log.info("Completed deleteTodo in TodoController at : " + System.currentTimeMillis());
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/{todoId}")
    public ResponseEntity<TodoModel> getOneTodo(@PathVariable final Long todoId) {
        log.info("Started getOneTodo in TodoController at : " + System.currentTimeMillis());
        final TodoModel todoModel = todoService.getOneTodo(todoId);
        log.info("Completed getOneTodo in TodoController at : " + System.currentTimeMillis());
        return new ResponseEntity<>(todoModel, HttpStatus.OK);
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<TodoModel>> getAllTodos() {
        log.info("Started getAllTodos in TodoController at : " + System.currentTimeMillis());
        final List<TodoModel> allTodos = todoService.getAllTodos();
        log.info("Completed getAllTodos in TodoController at : " + System.currentTimeMillis());
        return new ResponseEntity<>(allTodos, HttpStatus.OK);
    }
}
