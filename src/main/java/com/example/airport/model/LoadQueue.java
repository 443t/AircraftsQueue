package com.example.airport.model;

import com.example.airport.repository.AircraftRepo;
import com.example.airport.service.impl.QueueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadQueue {

    @Autowired
    QueueServiceImpl queueServiceImpl;

    @Bean
    CommandLineRunner initQueue(AircraftRepo repository) {


        return args -> {
            queueServiceImpl.initQueue();
        };

    }


}
