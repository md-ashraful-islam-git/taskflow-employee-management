package com.taskflow.backend.dto;

public class DashboardResponse {

    private long totalUsers;
    private long totalTasks;
    private long completedTasks;
    private long pendingTasks;
    private long inProgressTasks;

    public DashboardResponse(long totalUsers, long totalTasks,
                             long completedTasks, long pendingTasks,
                             long inProgressTasks) {

        this.totalUsers = totalUsers;
        this.totalTasks = totalTasks;
        this.completedTasks = completedTasks;
        this.pendingTasks = pendingTasks;
        this.inProgressTasks = inProgressTasks;
    }

    public long getTotalUsers() {
        return totalUsers;
    }

    public long getTotalTasks() {
        return totalTasks;
    }

    public long getCompletedTasks() {
        return completedTasks;
    }

    public long getPendingTasks() {
        return pendingTasks;
    }

    public long getInProgressTasks() {
        return inProgressTasks;
    }
}
