package com.ecoscan.eco_backend.repository;

import com.ecoscan.eco_backend.entity.AirQuality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirQualityRepository extends JpaRepository<AirQuality, Long> {
}
