package com.taskflow.backend.controller;

import com.taskflow.backend.entity.Task;
import com.taskflow.backend.entity.User;
import com.taskflow.backend.service.TaskService;
import com.taskflow.backend.repository.UserRepository;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.taskflow.backend.entity.TaskStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/my/tasks")
@PreAuthorize("hasRole('EMPLOYEE')")
public class EmployeeTaskController {

    private final TaskService taskService;
    private final UserRepository userRepository;

    public EmployeeTaskController(
            TaskService taskService,
            UserRepository userRepository) {
        this.taskService = taskService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Task> getMyTasks(
            @AuthenticationPrincipal UserDetails userDetails) {

        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return taskService.getTasksByUser(user.getId());
    }

    @PatchMapping("/{taskId}/status")
    public ResponseEntity<Task> updateMyTaskStatus(
            @PathVariable Long taskId,
            @RequestBody TaskStatus status,
            @AuthenticationPrincipal UserDetails userDetails) {

        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Task task = taskService.getTaskById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (!task.getAssignedTo().getId().equals(user.getId())) {
            return ResponseEntity.status(403).build();
        }

        Task updatedTask = taskService.updateTaskStatus(taskId, status);

        return ResponseEntity.ok(updatedTask);
    }
}