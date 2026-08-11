package com.gustavo.taskflow.patterns.chain;

import com.gustavo.taskflow.model.Task;
import com.gustavo.taskflow.model.TaskInvalidaException;

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
