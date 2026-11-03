package com.taskflow.backend.service;

import com.taskflow.backend.dto.DashboardResponse;
import com.taskflow.backend.entity.TaskStatus;
import com.taskflow.backend.repository.UserRepository;
import com.taskflow.backend.repository.TaskRepository;

import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;
    private final TaskService taskService;

    public DashboardService(
            UserRepository userRepository,
            TaskRepository taskRepository,
            TaskService taskService) {

        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
        this.taskService = taskService;
    }

    public DashboardResponse getDashboardData() {

        long totalUsers = userRepository.count();

        long totalTasks = taskRepository.count();

        long completedTasks =
                taskService.getTaskCountByStatus(TaskStatus.COMPLETED);

        long pendingTasks =
                taskService.getTaskCountByStatus(TaskStatus.TODO);

        long inProgressTasks =
                taskService.getTaskCountByStatus(TaskStatus.IN_PROGRESS);

        return new DashboardResponse(
                totalUsers,
                totalTasks,
                completedTasks,
                pendingTasks,
                inProgressTasks
        );
    }
}
