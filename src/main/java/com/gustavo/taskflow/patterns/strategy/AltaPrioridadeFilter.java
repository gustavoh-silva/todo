package com.gustavo.taskflow.patterns.strategy;

import com.gustavo.taskflow.model.Priority;
import com.gustavo.taskflow.model.Task;

import java.util.List;

public class AltaPrioridadeFilter implements TaskFilter {
    @Override
    public List<Task> filtrar(List<Task> list) {
        return list.stream().filter((task) -> task.getPrioridade() == Priority.ALTA).toList();
    }
}