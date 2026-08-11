package com.gustavo.taskflow.patterns.chain;

import com.gustavo.taskflow.model.Task;
import com.gustavo.taskflow.model.TaskInvalidaException;

public class TamanhoValidator extends TaskValidator{
    @Override
    public void validar(Task task) {
        if (task.getTitulo() == null || task.getTitulo().length() > 100){
            throw new TaskInvalidaException("titulo muito grande");
        }
        if (proximo != null){
            proximo.validar(task);
        }
    }
}
