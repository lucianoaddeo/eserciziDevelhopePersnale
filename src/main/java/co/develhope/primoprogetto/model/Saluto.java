package co.develhope.primoprogetto.model;

public class Saluto {
    private String nome;
    private String provincia;
    private String saluto;

    public Saluto(String nome,String provincia){
        this.nome = nome;
        this.provincia = provincia;
        this.saluto = "Ciao "+nome+", com'è il tempo in "+provincia+"?";
    }

    public String getNome(){
        return nome;
    }

    public String getProvincia(){
        return provincia;
    }

    public String getSaluto(){
        return saluto;
    }
}
