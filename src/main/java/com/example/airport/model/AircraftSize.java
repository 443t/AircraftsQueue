package com.example.airport.model;

public enum AircraftSize {
    BIG(2), SMALL(1);
    private int priority;

    AircraftSize(int priority) {
        this.priority = priority;
    }

    public int priority() {
        return priority;
    }
}
