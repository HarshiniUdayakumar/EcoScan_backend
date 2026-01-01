package com.ecoscan.eco_backend.repository;

import com.ecoscan.eco_backend.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {

    // Add this method
    Optional<Location> findByCityAndStateAndCountry(String city, String state, String country);
}
