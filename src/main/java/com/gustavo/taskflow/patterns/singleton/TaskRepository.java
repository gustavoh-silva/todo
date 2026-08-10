package com.gustavo.taskflow.patterns.singleton;

public class TaskRepository {
    private static final TaskRepository instance = new TaskRepository();

    private TaskRepository() {
    }

    public static TaskRepository getInstance() {
        return instance;
    }
}
