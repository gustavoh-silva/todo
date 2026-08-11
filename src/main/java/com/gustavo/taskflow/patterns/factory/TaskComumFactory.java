package com.gustavo.taskflow.patterns.factory;

import com.gustavo.taskflow.model.Priority;
import com.gustavo.taskflow.model.Task;
import com.gustavo.taskflow.model.TaskComum;

public class TaskComumFactory implements TaskFactory{
    @Override
    public Task createTask(String titulo, long id, Priority prioridade) {
        return new TaskComum(titulo, id, prioridade);
    }
}
