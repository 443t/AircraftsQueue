package com.example.airport.model;

public enum AircraftType {
    EMERGENCY(4), VIP(3), CARGO(2), PASSENGER(1);

    private int priority;

    AircraftType(int priority) {
        this.priority = priority;
    }

    public int priority() {
        return priority;
    }
}
