package com.example.esercizioFlight.repositories;

import com.example.esercizioFlight.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight,String> {
}
