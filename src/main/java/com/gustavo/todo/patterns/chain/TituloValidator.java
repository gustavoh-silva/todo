package com.gustavo.todo.patterns.chain;

import com.gustavo.todo.model.Task;
import com.gustavo.todo.model.TaskInvalidaException;

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
