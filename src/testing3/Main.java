package testing3;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        System.out.println(formattaData());
    }
    public static String formattaData(){

        OffsetDateTime data = OffsetDateTime.parse("2023-03-01T13:00:00Z");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ITALY);
        return formatter.format(data);

    }
}
/*
Crea un oggetto OffsetDateTime da questa stringa 2023-03-01T13:00:00Z
Formatta la data ottenendo 01 marzo 2023
Stampa sulla console
Fai attenzione a usare almeno Java 8
Crea dei test per questo esercizio
 */