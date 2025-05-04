import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

        public static void main(String[] args) {
            Person p1 = new PersonBuilder("Luca","Rossi").build();

            Person p2 = new PersonBuilder("Mario","Belloni")
                    .setAddress("Via Napoli 11")
                    .setAge(32).build();

            System.out.println(p1+"\n"+p2);
        }

}
/*
Crea una classe Person con i campi firstName, lastName, age e address, i getter and i setter
Il costruttore accetterà un Builder in input
Creare una classe Builder che attraverso il costruttore e dei metodi specifici (tranne nome e cognome, gli altri campi sono opzionali) per costruire l'oggetto Person.
Creare due oggetti Person e stamparli a video
 */