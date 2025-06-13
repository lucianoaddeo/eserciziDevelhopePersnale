package co.develhope.primoprogetto.controller;


import co.develhope.primoprogetto.model.Movie;
import co.develhope.primoprogetto.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class PrimoController {
    //Crea un'applicazione Spring Boot con
    //Controllerv3/ciao che legge un dato nel database e lo restituisce nel body della chiamata.

    @Autowired
    private MovieRepository mr;

    @GetMapping("v3/ciao")
    public Movie movie(@RequestParam(name = "q") Integer id){
        Optional<Movie> opm = mr.findById(id);
        return opm.orElseThrow();//lancia NoSuchElementException
    }
}
