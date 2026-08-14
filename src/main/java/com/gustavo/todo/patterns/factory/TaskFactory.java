package com.gustavo.todo.patterns.factory;

import com.gustavo.todo.model.Priority;
import com.gustavo.todo.model.Task;

public interface TaskFactory {
    Task createTask(String titulo, long id, Priority prioridade);
}
