package com.gustavo.todo.patterns.chain;

import com.gustavo.todo.model.Task;

public abstract class TaskValidator {
    protected TaskValidator proximo;
    public TaskValidator setProximo(TaskValidator proximo) { return this; }
    public abstract void validar(Task task);
}
