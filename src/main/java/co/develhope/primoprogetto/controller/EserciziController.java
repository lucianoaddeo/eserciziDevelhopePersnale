package co.develhope.primoprogetto.controller;

import co.develhope.primoprogetto.model.Saluto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EserciziController {

    @GetMapping("v2/ciao/{provincia}")
    public Saluto dettagliSaluto(@RequestParam String nome, @PathVariable String provincia){
        return new Saluto(nome, provincia);
    }
}
