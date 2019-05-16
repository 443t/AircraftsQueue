package com.example.airport.model;

import java.util.Comparator;

public class AircraftComparator implements Comparator<Aircraft> {

    public int compare(Aircraft a1, Aircraft a2) {
        if (!(a1.getType().equals(a2.getType()))) {
            return a2.getType().priority() - a1.getType().priority();
        } else if (!(a1.getSize().equals(a2))) {
            return a2.getSize().priority() - a1.getSize().priority();
        } else return (int) ((a1.getId() - a2.getId()));
    }

}
