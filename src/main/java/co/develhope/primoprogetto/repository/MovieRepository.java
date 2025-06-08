package co.develhope.primoprogetto.repository;

import co.develhope.primoprogetto.model.Movie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MovieRepository {
    //simulo il db
    Map<Integer, Movie> movies = Map.of(
            1,new Movie("The Matrix",1999),
            2,new Movie("Il gladiatore", 2003),
            3,new Movie("Django", 2011),
            4, new Movie("The Matrix revolution", 2003),
            5, new Movie("Il gladiatore 2", 2024),
            6, new Movie("The Hobbit", 2012)
    );

    public Movie findById(int id){
        return movies.get(id);
        //id non è nella mappa
        //restituisce null
    }

   public List<Movie> findAll(){
       Collection<Movie> valori = movies.values();
       //values() non restituisce una lista perchè
       //nella mappa i valiri non sono orinati
       //Collection è un'interfaccia generica
        return new ArrayList<>(valori);
   }
}

