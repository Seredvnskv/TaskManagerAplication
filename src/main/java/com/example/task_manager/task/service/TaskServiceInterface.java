package com.example.task_manager.task.service;

import com.example.task_manager.task.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskServiceInterface {
    List<Task> getAllTasks();
    void deleteAllTasks();
    Optional<Task> getTaskById(UUID id);
    Optional<Task> getTaskByTitle(String title);
    List<Task> getTasksByUserId(UUID id);
    Task createTask(Task task);
    Task updateTask(Task task);
    void deleteTask(UUID id);
}
