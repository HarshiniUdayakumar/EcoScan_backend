package com.ecoscan.eco_backend.controller;

import com.ecoscan.eco_backend.entity.AirQuality;
import com.ecoscan.eco_backend.service.AirQualityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/airquality")
@CrossOrigin(origins = "https://eco-scan-frontend-three.vercel.app/")
public class AirQualityController {

    private final AirQualityService airQualityService;

    public AirQualityController(AirQualityService airQualityService) {
        this.airQualityService = airQualityService;
    }

    // 1️⃣ Create / Save new AirQuality record
    @PostMapping("/add")
    public ResponseEntity<AirQuality> addAirQuality(@RequestBody AirQuality airQuality) {
        AirQuality savedRecord = airQualityService.saveAirQuality(airQuality);
        return ResponseEntity.ok(savedRecord);
    }

    // 2️⃣ Get all AirQuality records
    @GetMapping("/all")
    public ResponseEntity<List<AirQuality>> getAllAirQuality() {
        List<AirQuality> list = airQualityService.getAllAirQuality();
        return ResponseEntity.ok(list);
    }

    // 3️⃣ Get AirQuality by ID
    @GetMapping("/{id}")
    public ResponseEntity<AirQuality> getAirQualityById(@PathVariable Long id) {
        Optional<AirQuality> airQuality = airQualityService.getAirQualityById(id);
        return airQuality.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 4️⃣ Delete AirQuality by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAirQuality(@PathVariable Long id) {
        airQualityService.deleteAirQuality(id);
        return ResponseEntity.ok("Deleted AirQuality record with ID: " + id);
    }
}
