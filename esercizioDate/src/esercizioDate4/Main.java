package esercizioDate4;

import java.time.OffsetDateTime;

public class Main {
    public static void main(String[] args) {
        // Parsing della data
        OffsetDateTime data = OffsetDateTime.parse("2023-03-01T13:00:00Z");
        //stampa
        System.out.println(data.plusYears(1).minusMonths(1).plusDays(7));


    }
}
/*
Crea un oggetto data da questa stringa 2023-03-01T13:00:00Z
aggiungi un anno
sottrai un mese
aggiungi 7 giorni
Stampa il risultato localizzata per l'Italia
 */