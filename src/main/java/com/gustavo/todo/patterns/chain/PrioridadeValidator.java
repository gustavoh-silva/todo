package com.gustavo.todo.patterns.chain;

import com.gustavo.todo.model.Task;
import com.gustavo.todo.model.TaskInvalidaException;

public class PrioridadeValidator extends TaskValidator{
    @Override
    public void validar(Task task) {
        if (task.getPrioridade() == null){
            throw new TaskInvalidaException("prioridade não pode ser nula");
        }
        if (proximo != null){
            proximo.validar(task);
        }
    }
}
