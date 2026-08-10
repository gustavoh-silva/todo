package com.gustavo.taskflow.patterns.singleton;

import com.gustavo.taskflow.model.Task;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskRepository {
    private static final TaskRepository instance = new TaskRepository();

    private TaskRepository() {
    }

    public static TaskRepository getInstance() {
        return instance;
    }

    private final List<Task> campo = new ArrayList();

    public void addTask(Task task) {
        this.campo.add(task);
    }

    public List<Task> getAll(){
        return this.campo;
    }

    public Task findById(int id) {
        for (Task task : this.campo) {
            if (task.getId() == id) { return task; }
        }
        return null;
    }

    public boolean remove(int id){
        for (Task task : this.campo){
            if (task.getId() == id){
                return this.campo.remove(task);
            }
        }
        return false;
    }
}

