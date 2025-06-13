package co.develhope.primoprogetto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Integer anno;

    public Movie(String nome, Integer anno){
        this.nome = nome;
        this.anno = anno;
    }

    //Hibernate necessita un costruttore vuoto per creare gli oggetti
    public Movie(){}


    //getter servono per la serializzazione
    public Integer getAnno() {
        return anno;
    }

    public String getNome(){
        return nome;
    }

    public Integer getId(){ return id; }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
