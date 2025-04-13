package testing2;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Main {
    public static void main(String[] args) {
        //stampe
        System.out.println("data FULL: "+formattaDataFull());
        System.out.println("data MEDIUM: "+formattaDataMedium());
        System.out.println("data SHORT: "+formattaDataShort());
    }

    public static String formattaDataFull(){
        //parsing
        OffsetDateTime data = OffsetDateTime.parse("2002-03-01T13:00:00Z");
        //format Full con necessità di specificare il ZoneID
        DateTimeFormatter formatter =
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withZone(ZoneId.of("Europe/Rome"));

        return formatter.format(data);
    }

    public static String formattaDataMedium(){
        //parsing
        OffsetDateTime data = OffsetDateTime.parse("2002-03-01T13:00:00Z");
        //format Medium
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

        return formatter.format(data);
    }
    public static String formattaDataShort(){
        //parsing
        OffsetDateTime data = OffsetDateTime.parse("2002-03-01T13:00:00Z");
        //formato short
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

        return formatter.format(data);
    }
}
/*
Crea un oggetto OffsetDateTime da questa stringa 2002-03-01T13:00:00Z
Formatta la data ottenuta in FULL, MEDIUM e SHORT
Stampa le varie versioni -Crea dei test per questo esercizio
 */