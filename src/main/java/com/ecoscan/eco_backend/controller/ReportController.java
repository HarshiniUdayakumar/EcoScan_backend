package com.ecoscan.eco_backend.controller;

import com.ecoscan.eco_backend.dto.ReportRequest;
import com.ecoscan.eco_backend.entity.Report;
import com.ecoscan.eco_backend.repository.ReportRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "http://localhost:5173")
public class ReportController {

    private final ReportRepository reportRepository;

    public ReportController(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @PostMapping
    public ResponseEntity<?> submitReport(@RequestBody ReportRequest request) {

        if (request.getLocation() == null || request.getDescription() == null) {
            return ResponseEntity.badRequest().body("All fields are required!");
        }

        Report report = new Report();
        report.setLocation(request.getLocation());
        report.setDescription(request.getDescription());
        report.setUserId(request.getUserId());

        reportRepository.save(report);

        return ResponseEntity.ok("Report submitted successfully!");
    }
}
