
package com.taskflow.backend.repository;

import com.taskflow.backend.entity.Task;
import com.taskflow.backend.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByAssignedToId(Long userId);

    List<Task> findByStatus(TaskStatus status);

    List<Task> findByAssignedToIdAndStatus(Long userId, TaskStatus status);
}

