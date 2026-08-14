package com.gustavo.todo.model;

public class TaskInvalidaException extends RuntimeException {
    public TaskInvalidaException(String mensagem) {
        super(mensagem);
    }
}
