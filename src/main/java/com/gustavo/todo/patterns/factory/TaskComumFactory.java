package com.gustavo.todo.patterns.factory;

import com.gustavo.todo.model.Priority;
import com.gustavo.todo.model.Task;
import com.gustavo.todo.model.TaskComum;

public class TaskComumFactory implements TaskFactory{
    @Override
    public Task createTask(String titulo, long id, Priority prioridade) {
        return new TaskComum(titulo, id, prioridade);
    }
}
