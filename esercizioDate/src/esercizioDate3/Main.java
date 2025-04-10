package esercizioDate3;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.OffsetDateTime;

public class Main {
    public static void main(String[] args) {

        // Parsing della data
        OffsetDateTime data = OffsetDateTime.parse("2023-03-01T13:00:00Z");

        // Estrazione dei componenti
        int anno = data.getYear();
        Month mese = data.getMonth();
        int giornoNum = data.getDayOfMonth();
        DayOfWeek giornoSettimana= data.getDayOfWeek();

        // Stampa dei risultati
        System.out.println("Anno: " + anno);
        System.out.println("Mese: " + mese);
        System.out.println("Giorno del mese: " + giornoNum);
        System.out.println("Giorno della settimana: " + giornoSettimana);
    }
}
