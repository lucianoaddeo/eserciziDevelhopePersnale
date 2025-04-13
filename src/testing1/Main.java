package testing1;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        //stampa la data applicando il formato personalizzato
        System.out.println(formattaData());


    }

    public static String formattaData(){
        // Parsing della data
        OffsetDateTime data = OffsetDateTime.parse("2023-03-01T13:00:00Z");

        //operazioni sulla data (OffsetDateTime è un oggetto immutabile)
        OffsetDateTime dataModificata = data.plusYears(1).minusMonths(1).plusDays(7);

        //formatter personlizzato
        DateTimeFormatter formatter  =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss", Locale.ITALY);

        return formatter.format(dataModificata);
    }
}
