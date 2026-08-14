package com.gustavo.taskflow.repository;

import com.gustavo.taskflow.model.Task;

import java.io.IOException;
import java.util.List;

public interface TaskRepositoryInterface {
    void addTask(Task task);
    List<Task> getAll();
    Task findById(long id);
    boolean remove(long id);
    void save();
}
