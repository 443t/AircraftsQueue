package com.example.airport.exception;

public class AircraftNotFoundException extends RuntimeException {

    public AircraftNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}