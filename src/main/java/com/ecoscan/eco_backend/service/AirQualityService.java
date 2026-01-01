package com.ecoscan.eco_backend.service;

import com.ecoscan.eco_backend.entity.AirQuality;
import com.ecoscan.eco_backend.entity.Location;
import com.ecoscan.eco_backend.repository.AirQualityRepository;
import com.ecoscan.eco_backend.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirQualityService {

    private final AirQualityRepository airQualityRepository;
    private final LocationRepository locationRepository;

    public AirQualityService(AirQualityRepository airQualityRepository,
                             LocationRepository locationRepository) {
        this.airQualityRepository = airQualityRepository;
        this.locationRepository = locationRepository;
    }

    // Save AirQuality record
    public AirQuality saveAirQuality(AirQuality airQuality) {
        // If location exists, attach it, otherwise save new location
        Location location = airQuality.getLocation();
        Optional<Location> existingLocation = locationRepository.findByCityAndStateAndCountry(
                location.getCity(), location.getState(), location.getCountry()
        );

        if (existingLocation.isPresent()) {
            airQuality.setLocation(existingLocation.get());
        } else {
            locationRepository.save(location);
            airQuality.setLocation(location);
        }

        return airQualityRepository.save(airQuality);
    }

    // Get all AirQuality records
    public List<AirQuality> getAllAirQuality() {
        return airQualityRepository.findAll();
    }

    // Get AirQuality by ID
    public Optional<AirQuality> getAirQualityById(Long id) {
        return airQualityRepository.findById(id);
    }

    // Delete AirQuality by ID
    public void deleteAirQuality(Long id) {
        airQualityRepository.deleteById(id);
    }
}
