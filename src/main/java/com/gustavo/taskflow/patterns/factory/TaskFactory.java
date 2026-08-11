package com.gustavo.taskflow.patterns.factory;

import com.gustavo.taskflow.model.Priority;
import com.gustavo.taskflow.model.Task;

public interface TaskFactory {
    Task createTask(String titulo, long id, Priority prioridade);
}
