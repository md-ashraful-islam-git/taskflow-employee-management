
package com.taskflow.backend.dto;

import com.taskflow.backend.entity.Role;

public class LoginResponse {

    private Long id;
    private String fullName;
    private String email;
    private Role role;
    private String message;

    public LoginResponse(Long id, String fullName,
                         String email, Role role, String message) {

        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public String getMessage() {
        return message;
    }
}