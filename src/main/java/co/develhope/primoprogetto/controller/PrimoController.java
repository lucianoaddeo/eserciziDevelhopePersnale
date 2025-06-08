package co.develhope.primoprogetto.controller;

import co.develhope.primoprogetto.model.Movie;
import co.develhope.primoprogetto.repository.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
                      @RequestParam(required = false) Integer limit ){
        List<Movie> risultati= new ArrayList<>();
        if(title!=null) {
            for (Movie m : mr.findAll()) {
                if (m.getNome().toLowerCase().contains(title.toLowerCase())) {
                    risultati.add(m);
                }
            }
            if(sort != null){
                switch (sort){
                    case "anno":
                        risultati.sort(Comparator.comparing(Movie::getAnno));
                        if(limit!=null){
                            List<Movie> limitati = new ArrayList<>();
                            for(int i =0; i<((limit==risultati.size()) ? limit : risultati.size()); i++){
                                limitati.add(risultati.get(i));
                            }
                            return limitati;
                        }
                        return risultati;
                    case "titolo":
                        risultati.sort(Comparator.comparing(Movie::getNome));
                        if(limit!=null){
                            List<Movie> limitati = new ArrayList<>();
                            for(int i =0; i< ((limit==risultati.size()) ? limit : risultati.size()); i++){
                                limitati.add(risultati.get(i));
                            }
                            return limitati;
                        }
                        return risultati;
                }
            }
            return risultati;
        }
        if(sort != null){
            switch (sort){
                case "anno":
                    risultati.sort(Comparator.comparing(Movie::getAnno));
                    if(limit!=null){
                        List<Movie> limitati = new ArrayList<>();
                        for(int i =0; i<((limit==mr.findAll().size()) ? limit : mr.findAll().size()); i++){
                            limitati.add(mr.findAll().get(i));
                        }
                        return limitati;
                    }
                    return risultati;
                case "titolo":
                    risultati.sort(Comparator.comparing(Movie::getNome));
                    if(limit!=null){
                        List<Movie> limitati = new ArrayList<>();
                        for(int i =0; i<((limit==mr.findAll().size()) ? limit : mr.findAll().size()); i++){
                            limitati.add(mr.findAll().get(i));
                        }
                        return limitati;
                    }
                    return risultati;
            }
        }
        if(limit!=null){
            List<Movie> limitati = new ArrayList<>();
            for(int i =0; i<((limit==mr.findAll().size()) ? limit : mr.findAll().size()); i++){
                limitati.add(mr.findAll().get(i));
            }
            return limitati;
        }
        return mr.findAll();
    }
}
