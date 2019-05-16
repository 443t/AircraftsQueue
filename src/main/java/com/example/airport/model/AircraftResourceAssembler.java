package com.example.airport.model;


import com.example.airport.resource.AircraftQueueResource;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class AircraftResourceAssembler implements ResourceAssembler<Aircraft, Resource<Aircraft>> {

    @Override
    public Resource<Aircraft> toResource(Aircraft aircraft) {

        return new Resource<>(aircraft,
                linkTo(methodOn(AircraftQueueResource.class).all()).withRel("aircrafts"));
    }
}
