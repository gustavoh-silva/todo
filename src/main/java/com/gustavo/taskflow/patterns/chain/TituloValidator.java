package com.gustavo.taskflow.patterns.chain;

import com.gustavo.taskflow.model.Task;
import com.gustavo.taskflow.model.TaskInvalidaException;

public class TituloValidator extends TaskValidator{
    @Override
    public void validar(Task task) {
        if (task.getTitulo() == null || task.getTitulo().isEmpty()){
            throw new TaskInvalidaException("titulo invalido");
        }
        if (proximo != null){
            proximo.validar(task);
        }
    }
}
