package com.taskflow.backend.controller;

import com.taskflow.backend.dto.DashboardResponse;
import com.taskflow.backend.service.DashboardService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "http://localhost:4200")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public DashboardResponse getDashboardData() {
        return dashboardService.getDashboardData();
    }
}
