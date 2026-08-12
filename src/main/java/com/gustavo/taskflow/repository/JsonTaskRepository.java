package com.gustavo.taskflow.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.gustavo.taskflow.model.Task;
import com.gustavo.taskflow.model.TaskComum;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JsonTaskRepository implements TaskRepositoryInterface{

    private static final String ARQUIVO = "tasks.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private List<Task> tarefas;

    public JsonTaskRepository() {
        if (Files.exists(Path.of(ARQUIVO))){
            try{
                this.tarefas = gson.fromJson(ARQUIVO, new TypeToken<List<TaskComum>>(){}.getType());
            }catch (JsonSyntaxException e){
                System.out.println("Arquivo corrompido");
            }
        } else{
            this.tarefas = new ArrayList<>();
        }
    }

    private void salvar() throws IOException {
        String json = gson.toJson(tarefas);
        Files.writeString(Path.of(ARQUIVO), json);
    }

    @Override
    public void addTask(Task task) throws IOException {
        this.tarefas.add(task);
        salvar();
    }

    @Override
    public List<Task> getAll() {
        return Collections.unmodifiableList(tarefas);
    }

    @Override
    public Task findById(long id) {
        for (Task task : this.tarefas){
            if (task.getId() == id){
                return task;
            }
        }
        return null;
    }

    @Override
    public boolean remove(long id) throws IOException {
        for (Task task : this.tarefas){
            if (task.getId() == id){
                return this.tarefas.remove(task);
            }
        }
        salvar();
        return false;
    }
}
