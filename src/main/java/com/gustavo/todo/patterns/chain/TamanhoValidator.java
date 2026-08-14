package com.gustavo.todo.patterns.chain;

import com.gustavo.todo.model.Task;
import com.gustavo.todo.model.TaskInvalidaException;

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
