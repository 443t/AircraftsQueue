package com.example.airport.service.impl;

import com.example.airport.model.Aircraft;
import com.example.airport.model.AircraftComparator;
import com.example.airport.service.QueueService;
import com.example.airport.repository.AircraftRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


@Service
public class QueueServiceImpl implements QueueService {

    @Autowired
    AircraftRepo aircraftRepo;

    private static PriorityQueue<Aircraft> aircraftsQueue = new PriorityQueue<>(new AircraftComparator());

    public void initQueue() {
        Iterable<Aircraft> aircrafts = aircraftRepo.findAll();
        for (Aircraft a : aircrafts) {
            aircraftsQueue.add(a);
        }
    }

    public void enqueue(Aircraft aircraft) {
        aircraftsQueue.add(aircraft);
    }

    public Aircraft dequeue() {
        return aircraftsQueue.poll();
    }

    public List<Aircraft> all() {

        List<Aircraft> aircrafts = new ArrayList<>();
        for (Aircraft aircraft : aircraftsQueue) {
            aircrafts.add(aircraft);
        }
        return aircrafts;

    }


}
