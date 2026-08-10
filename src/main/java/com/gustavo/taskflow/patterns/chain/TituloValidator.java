package com.gustavo.taskflow.patterns.chain;

import com.gustavo.taskflow.model.Task;

public class TituloValidator extends TaskValidator{
    @Override
    public void validar(Task task) {
        if (task.getTitulo() == null || task.getTitulo().isEmpty()){
            throw new RuntimeException("titulo invalido");
        }
        if (proximo != null){
            proximo.validar(task);
        }
    }
}
