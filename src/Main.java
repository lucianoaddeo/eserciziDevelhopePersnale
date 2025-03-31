import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


        double y = 1.0/3;
        System.out.println(y);
        System.out.println((float)y);

        Set<Persona> persone = creaSet();
        System.out.println(persone);
        Persona persona1 = new Persona("Marco");
//        Persona persona2 = new Persona("Marco");
//        persona2.nome = "Luca";
//        System.out.println(persona1.equals(persona2));
//        System.out.println(persona1);
//        System.out.println(persona2);
        if(persone.contains(persona1))
        {
            System.out.println("è contenuto.");
        }
        else{
            System.out.println("non è contenuto.");
        }

    }

    public static Set<Persona> creaSet(){
        Set<Persona> persone = new HashSet<>();
        persone.add(new Persona("Marco"));
        persone.add(new Persona("Luca"));
        persone.add(new Persona("Giovanni"));
        return persone;
    }
}

/*
* Scrivere una funzione che restituisca un HashSet riempito
Creare un oggetto dello stesso tipo inserito nell'HashSet e popolarlo
Verificare che l' elemento sia parte del Set e stampare il risultato*/

/*
* import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<String> colori = creaSet();
        System.out.println(colori);
        String colore = "giallo";
        if(colori.contains(colore))
        {
            System.out.println("è contenuto.");
        }
        else{
            System.out.println("non è contenuto.");
        }
    }

    public static Set<String> creaSet(){
        Set<String> colori = new HashSet<>();
        colori.add("rosso");
        colori.add("verde");
        colori.add("giallo");
        return colori;
    }
}*/