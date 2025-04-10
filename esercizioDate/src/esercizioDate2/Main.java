package esercizioDate2;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        //stringa base
        String input = "2023-03-01T13:00:00Z";
        //oggetto OffsetDateTime
        OffsetDateTime dataOffset = OffsetDateTime.parse(input);
        //formato richiesto 01 marzo 2023
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy",Locale.ITALIAN);
        //Stampa
        System.out.println(formatter.format(dataOffset));
    }

}

