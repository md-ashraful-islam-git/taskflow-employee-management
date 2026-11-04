package com.taskflow.backend.controller;

import com.taskflow.backend.dto.LoginRequest;
import com.taskflow.backend.dto.LoginResponse;
import com.taskflow.backend.service.UserService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
}
