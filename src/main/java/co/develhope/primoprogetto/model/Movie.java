package co.develhope.primoprogetto.model;

public class Movie {
    private String nome;
    private Integer anno;

    public Movie(String nome, Integer anno){
        this.nome = nome;
        this.anno = anno;
    }


    //getter servono per la serializzazione
    public Integer getAnno() {
        return anno;
    }

    public String getNome(){
        return nome;
    }
}
