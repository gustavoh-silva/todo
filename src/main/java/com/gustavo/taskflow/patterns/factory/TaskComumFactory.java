package com.gustavo.taskflow.patterns.factory;

import com.gustavo.taskflow.model.Priority;
import com.gustavo.taskflow.model.Task;

public class TaskComumFactory implements TaskFactory{
    @Override
    public Task createTask(String titulo, long id, Priority prioridade) {
        return null;
    }
}
