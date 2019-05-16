package com.example.airport.resource;

import com.example.airport.model.Aircraft;
import com.example.airport.model.AircraftResourceAssembler;
import com.example.airport.service.impl.QueueServiceImpl;
import com.example.airport.repository.AircraftRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;


@RestController
public class AircraftQueueResource {

    @Autowired
    QueueServiceImpl queueServiceImpl;


    private final AircraftRepo aircraftRepo;
    //
    private final AircraftResourceAssembler assembler;

    AircraftQueueResource(AircraftRepo repository,
                          AircraftResourceAssembler assembler) {

        this.aircraftRepo = repository;
        this.assembler = assembler;
    }

    @GetMapping("/aircrafts")
    public ResponseEntity<Object> all() {
        return new ResponseEntity<>(queueServiceImpl.all(), HttpStatus.OK);
    }

    @PostMapping("/aircrafts")
    public ResponseEntity<Object> enqueue(@RequestBody Aircraft newAircraft) throws URISyntaxException {
        queueServiceImpl.enqueue(newAircraft);
        aircraftRepo.save(newAircraft);
        return new ResponseEntity<>("Aircraft is created successfully", HttpStatus.CREATED);
    }

    @Async
    @GetMapping("/dequeue")
    public ResponseEntity<Object> dequeue() {
        Long id = queueServiceImpl.dequeue().getId();
        aircraftRepo.deleteById(id);
        return new ResponseEntity<>("Aircraft is dequeued successfully", HttpStatus.OK);
    }

}





