package com.gustavo.taskflow.patterns.strategy;

import com.gustavo.taskflow.model.Task;

import java.util.List;
import java.util.stream.Stream;

public class PendentesFilter implements TaskFilter {
    @Override
    public List<Task> filtrar(List<Task> list) {
        return list.stream().filter((task) -> !task.isConcluida()).toList();
    }
}
