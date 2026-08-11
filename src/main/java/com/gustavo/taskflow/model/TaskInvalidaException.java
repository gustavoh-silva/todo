package com.gustavo.taskflow.model;

public class TaskInvalidaException extends RuntimeException {
    public TaskInvalidaException(String mensagem) {
        super(mensagem);
    }
}
