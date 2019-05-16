package com.example.airport.repository;

import com.example.airport.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AircraftRepo extends JpaRepository<Aircraft, Long> {
}
