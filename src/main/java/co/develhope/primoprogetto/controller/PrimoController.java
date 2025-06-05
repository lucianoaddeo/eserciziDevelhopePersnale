package co.develhope.primoprogetto.controller;

import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
//@RequestMapping()
public class PrimoController {

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
}
