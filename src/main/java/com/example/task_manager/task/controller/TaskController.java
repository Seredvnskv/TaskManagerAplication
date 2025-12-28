package com.example.task_manager.task.controller;

import com.example.task_manager.task.Task;
import com.example.task_manager.task.dto.CreateTaskDTO;
import com.example.task_manager.task.dto.ReadTaskDTO;
import com.example.task_manager.task.mapper.TaskMapper;
import com.example.task_manager.task.service.TaskService;
import com.example.task_manager.user.User;
import com.example.task_manager.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    private final UserService userService;
    private final TaskMapper taskMapper;

    @Autowired
    public TaskController(TaskService taskService, UserService userService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.userService = userService;
        this.taskMapper = taskMapper;
    }

    @GetMapping
    public ResponseEntity<List<ReadTaskDTO>> getTasks() {
        List<Task> tasks = taskService.getAllTasks();

        if (tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            List<ReadTaskDTO> dtos = taskMapper.toDTO(tasks);
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReadTaskDTO> getTaskById(UUID id) {
        Task optionalTask = taskService.getTaskById(id).orElse(null);

        if (optionalTask == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            ReadTaskDTO dto = taskMapper.toDTO(optionalTask);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<ReadTaskDTO> getTaskByTitle(String title) {
        Task optionalTask = taskService.getTaskByTitle(title).orElse(null);

        if (optionalTask == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            ReadTaskDTO dto = taskMapper.toDTO(optionalTask);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<ReadTaskDTO>> getTasksByUserId(UUID id) {
        List<Task> tasks = taskService.getTasksByUserId(id);

        if (tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            List<ReadTaskDTO> dtos = taskMapper.toDTO(tasks);
            return new ResponseEntity<>(dtos, HttpStatus.OK);
        }
    }
}
