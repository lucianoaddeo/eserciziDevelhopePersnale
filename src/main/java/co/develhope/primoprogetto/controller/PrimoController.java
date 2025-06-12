package co.develhope.primoprogetto.controller;

import co.develhope.primoprogetto.model.Movie;
import co.develhope.primoprogetto.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
//@RequestMapping()
public class PrimoController {
    MovieRepository mr = new MovieRepository();

    @RequestMapping(method = GET, path = "{qualcosa}")
    public String homeCiao(@PathVariable(value = "qualcosa") String nome){
        return "Ciao " + nome;
    }

//    Scrivi una applicazione web Spring Boot che alla endpoint GET v1/ciao?
//    nome=Giuseppe&provincia=Lombardia risponde con "Ciao Giuseppe,
//    com'è il tempo in Lombardia?"

    @GetMapping("v1/ciao")
    public String salutaProvincia(@RequestParam(name = "nome", defaultValue = "sconosciuto", required = false) String n,
                                  @RequestParam(value = "provincia", defaultValue = "Italia", required = false) String p){
        return "Ciao "+n+" com'è il tempo in "+p+"?";
    }

    @GetMapping("v1/movie")
    public List<Movie> list(@RequestParam(required = false) String title,
                      @RequestParam(required = false) String sort,
                      @RequestParam(required = false) Integer limit){

        List<Movie> tutti = mr.findAll();
        List<Movie> risultati= new ArrayList<>();

        //filtra per titolo
        if(title!=null) {

            for (Movie m : mr.findAll()) {
                if (m.getNome().toLowerCase().contains(title.toLowerCase())) {
                    risultati.add(m);
                }
            }
        }
        else {
            risultati.addAll(tutti);
        }
        //ordina i risultati
        if(sort != null){
            switch (sort){
                case "anno":
                    risultati.sort(Comparator.comparing(Movie::getAnno));
                    break;
                case "titolo":
                    risultati.sort(Comparator.comparing(Movie::getNome));
                    break;
                default:
                    throw new HttpStatusCodeException(HttpStatus.BAD_REQUEST) {};
            }
        }
        if(limit!=null){
            risultati = risultati.subList(0,Math.min(limit,risultati.size()));
        }
        return risultati;
    }
}
