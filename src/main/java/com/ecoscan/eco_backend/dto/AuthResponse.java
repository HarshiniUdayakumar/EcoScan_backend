package com.ecoscan.eco_backend.dto;

public class AuthResponse {
    private String message;
    private Long userId; // optional, for frontend use

    public AuthResponse(String message) {
        this.message = message;
    }

    public AuthResponse(String message, Long userId) {
        this.message = message;
        this.userId = userId;
    }

    // getters & setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
