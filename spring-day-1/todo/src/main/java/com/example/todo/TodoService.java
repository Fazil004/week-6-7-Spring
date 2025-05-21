package com.example.todo;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private final List<Todo> todoList = new ArrayList<>();
    private long currentId = 1;

    public List<Todo> getAllTodos() {
        return todoList;
    }

    public Todo addTodo(Todo todo) {
        todo.id = currentId++;
        todoList.add(todo);
        return todo;
    }

    public Todo updateTodo(long id, Todo updatedTodo) {
        for (Todo todo : todoList) {
            if (todo.id == id) {
                todo.title = updatedTodo.title;
                todo.completed = updatedTodo.completed;
                return todo;
            }
        }
        return null;
    }

    public void deleteTodo(long id) {
        todoList.removeIf(todo -> todo.id == id);
    }
}
