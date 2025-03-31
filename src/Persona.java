import java.util.Objects;

public class Persona {

    public String nome;
    public String cognome;

    //costruttore parametrizzato
    Persona(String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (o == null || getClass() != o.getClass()) return false;
//        Persona persona = (Persona) o;
//        return Objects.equals(nome, persona.nome) && Objects.equals(cognome, persona.cognome);
//    }

        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona persona)) return false;
        return Objects.equals(nome, persona.nome) && Objects.equals(cognome, persona.cognome);
    }

//    @Override (fatto da loza)
//    public boolean equals(Object o){
//        //confronta gli indirizzi, se sono uguali vuol dire che sono lo stesso oggetto
//        if(this == o)
//            return true;
//        if(o == null || !(o instanceof Persona))
//            return false;
//        Persona p = (Persona) o;
//        return Objects.equals(this.nome, p.nome) && Objects.equals(this.cognome, p.cognome);
//    }


}
