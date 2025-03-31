import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        //creo un oggetto persona
        Persona persona1 = new Persona("Daniele", "Lazzaro");
        //chiamo la funzione per creare l'hashset
        Set<Persona> persone = creaSet();
        System.out.println(persone);

        if(persone.contains(persona1)){
            System.out.println("contiene"+persona1);
            persone.remove(persona1);
            System.out.println("eliminazione"+persona1+"...");
            //persone.removeIf() ??;
        }

        //creo un hashset uguale da passare al metodo removeAll
        Set<Persona> daRimuovere = creaSet();
        //svoto l'hashset
        persone.removeAll(daRimuovere);
        System.out.println(persone);

    }

    public static Set<Persona> creaSet(){
        Set<Persona> elencoPersone = new HashSet<>();
        elencoPersone.add(new Persona("Marco", "Silvestri"));
        elencoPersone.add(new Persona("Ilaria", "Salis"));
        elencoPersone.add(new Persona("Tommaso", "Buscetta"));
        elencoPersone.add(new Persona("Daniele", "Lazzaro"));
        return elencoPersone;
    }
}
/*
Scrivere una funzione che restituisca un hashset riempito
Creare un oggeto dello stesso tipo inserito nell'HashSet e popolarlo
Scorrere il set, per ogni elemento verificare se è uguale all'oggetto creato ed eliminarlo
Svuotare l'hashset, verificarlo e stampare il risultato
 */