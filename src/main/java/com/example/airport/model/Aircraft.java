package com.example.airport.model;


import javax.persistence.*;


@Entity
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private AircraftType type;

    @Enumerated(EnumType.STRING)
    @Column(length = 6)
    private AircraftSize size;

    public Aircraft() {
    }

    public Aircraft(AircraftType aircraftType, AircraftSize aircraftSize) {
        this.type = aircraftType;
        this.size = aircraftSize;
    }

    public Long getId() {
        return id;
    }

    public AircraftSize getSize() {
        return size;
    }

    public AircraftType getType() {
        return type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(AircraftType type) {
        this.type = type;
    }

    public void setSize(AircraftSize size) {
        this.size = size;
    }


}
