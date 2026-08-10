package com.gustavo.taskflow.patterns.singleton;

import com.gustavo.taskflow.model.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskRepository {
    private static final TaskRepository instance = new TaskRepository();

    private TaskRepository() {
    }

    public static TaskRepository getInstance() {
        return instance;
    }

    private final List<Task> tarefas = new ArrayList<>();

    public void addTask(Task task) {
        this.tarefas.add(task);
    }

    public List<Task> getAll(){
        return Collections.unmodifiableList(this.tarefas);
    }

    public Task findById(long id) {
        for (Task task : this.tarefas) {
            if (task.getId() == id) { return task; }
        }
        return null;
    }

    public boolean remove(long id){
        for (Task task : this.tarefas){
            if (task.getId() == id){
                return this.tarefas.remove(task);
            }
        }
        return false;
    }
}

