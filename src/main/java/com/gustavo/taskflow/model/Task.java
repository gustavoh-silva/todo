package com.gustavo.taskflow.model;

import java.time.OffsetDateTime;

public class Task {
    private long id;
    private String titulo;
    private String descricao;
    private Priority prioridade;
    private boolean concluida;
    private OffsetDateTime dataCriacao;

    public Task(String titulo, long id, Priority prioridade) {
        this.titulo = titulo;
        this.id = id;
        this.prioridade = prioridade;
        this.dataCriacao = OffsetDateTime.now();
    }

    public long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Priority getPrioridade() {
        return prioridade;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public OffsetDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void marcarConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}
