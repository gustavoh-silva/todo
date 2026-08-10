package com.gustavo.taskflow.patterns.strategy;

import com.gustavo.taskflow.model.Task;

import java.util.List;

public interface TaskFilter {
    List<Task> filtrar(List<Task> list);
}
