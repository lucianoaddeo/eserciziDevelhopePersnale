package esercizioDate5;

import java.time.OffsetDateTime;

public class Main {
    public static void main(String[] args) {
        //creazione due oggetti
        OffsetDateTime data1 = OffsetDateTime.parse("2023-03-01T13:00:00Z");
        OffsetDateTime data2 = OffsetDateTime.parse("2024-03-01T13:00:00Z");
        //verifiche e stampe dei risultati
        boolean precedente = data1.isBefore(data2);
        System.out.println("Data1 è precedente a Data2? " +precedente);

        boolean  successiva = data2.isAfter(data1);
        System.out.println("Data2 è successiva a Data1? " +successiva);

        boolean attuale = data1.isEqual(OffsetDateTime.now());
        System.out.println("Data1 è uguale all'orario attuale? "+attuale);

        attuale = data2.isEqual(OffsetDateTime.now());
        System.out.println("Data2 è uguale all'orario attuale? " +attuale);
    }
}
/*
Crea un oggetto data da questa stringa 2023-03-01T13:00:00Z
Crea un secondo oggetto data da questa stringa 2024-03-01T13:00:00Z
Verificare che la prima data è precedente alla seconda
Verificare che la seconda data è successiva alla prima
Verificare che le due date sono uguali ad ora
Stampa il risultato
 */