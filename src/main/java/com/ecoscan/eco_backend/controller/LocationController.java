package com.ecoscan.eco_backend.controller;

import com.ecoscan.eco_backend.entity.Location;
import com.ecoscan.eco_backend.repository.LocationRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationRepository locationRepository;

    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }
}
