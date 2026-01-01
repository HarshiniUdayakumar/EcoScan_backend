package com.ecoscan.eco_backend.dto;

public class ReportRequest {

    private String location;
    private String description;
    private Long userId;

    // Getters & Setters
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
}
