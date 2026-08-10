package com.gustavo.taskflow.patterns.chain;

import com.gustavo.taskflow.model.Task;

public abstract class TaskValidator {
    protected TaskValidator proximo;
    public TaskValidator setProximo(TaskValidator proximo) { return this; }
    public abstract void validar(Task task);
}
