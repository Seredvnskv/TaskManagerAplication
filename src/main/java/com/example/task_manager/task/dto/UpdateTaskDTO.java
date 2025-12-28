package com.example.task_manager.task.dto;

import java.util.List;
import java.util.UUID;

public class UpdateTaskDTO {
    String title;
    String description;
    String status;
    String dueDate;
    List<UUID> assignedUsers;
}
