package com.gustavo.todo.patterns.strategy;

import com.gustavo.todo.model.Task;

import java.util.List;

public interface TaskFilter {
    List<Task> filtrar(List<Task> list);
}
