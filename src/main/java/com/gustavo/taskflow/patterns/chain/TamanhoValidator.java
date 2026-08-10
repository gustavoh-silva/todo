package com.gustavo.taskflow.patterns.chain;

import com.gustavo.taskflow.model.Task;

public class TamanhoValidator extends TaskValidator{
    @Override
    public void validar(Task task) {
        if (task.getTitulo().length() > 100){
            throw new RuntimeException("titulo muito grande");
        }
        if (proximo != null){
            proximo.validar(task);
        }
    }
}
