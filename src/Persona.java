import java.util.Objects;

public class Persona {
    public String nome;

    Persona(String nome){
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(nome, persona.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}
