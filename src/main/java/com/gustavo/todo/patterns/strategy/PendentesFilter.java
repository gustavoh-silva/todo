package com.gustavo.todo.patterns.strategy;

import com.gustavo.todo.model.Task;

import java.util.List;
import java.util.stream.Stream;

public class PendentesFilter implements TaskFilter {
    @Override
    public List<Task> filtrar(List<Task> list) {
        return list.stream().filter((task) -> !task.isConcluida()).toList();
    }
}
