package com.example.esercizioFlight.controllers;

import com.example.esercizioFlight.Utils.RandomUtils;
import com.example.esercizioFlight.enums.Status;
import com.example.esercizioFlight.models.Flight;
import com.example.esercizioFlight.repositories.FlightRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
 @RequestMapping("/flights")
public class FlightController {

    private FlightRepository flightRepository;

    public FlightController(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }


    @PostMapping
    public ResponseEntity<?> createFlights(){

        System.out.println("Richiesta POST ::");
        List<Flight> list = new ArrayList<>();
        for(int i = 0; i < 50; i ++){

            Flight flight = new Flight(
                    RandomUtils.randomString(10),
                    RandomUtils.randomString(10),
                    RandomUtils.randomString(10),
                    Status.ONTIME
            );

            list.add(flight);
        }
        flightRepository.saveAll(list);

        return ResponseEntity.ok(list);
    }

    @GetMapping
    public ResponseEntity<?> getFlights(){
        List<Flight> flights = flightRepository.findAll();
        return ResponseEntity.ok(flights);
    }
}
