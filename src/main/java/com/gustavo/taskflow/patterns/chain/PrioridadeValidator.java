package com.gustavo.taskflow.patterns.chain;

import com.gustavo.taskflow.model.Task;

public class PrioridadeValidator extends TaskValidator{
    @Override
    public void validar(Task task) {
        if (task.getPrioridade() == null){
            throw new RuntimeException("prioridade não pode ser nula");
        }
        if (proximo != null){
            proximo.validar(task);
        }
    }
}
