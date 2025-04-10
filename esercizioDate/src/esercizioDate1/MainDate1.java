package esercizioDate1;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class MainDate1 {
    public static void main(String[] args) {
        //stringa da parsare
        String dataString = "2002-03-01T13:00:00Z";
        OffsetDateTime dataOffset = OffsetDateTime.parse(dataString);
        System.out.println(dataOffset);
        //formato FULL
        DateTimeFormatter fullFormatter =
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL,FormatStyle.FULL).withZone(ZoneId.of("Europe/Rome"));
        System.out.println(fullFormatter.format(dataOffset));
        //formato MEDIUM
        DateTimeFormatter mediumFormatter =
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        System.out.println(mediumFormatter.format(dataOffset));
        //formato SHORT
        DateTimeFormatter shortFormatter =
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(shortFormatter.format(dataOffset));

    }
}
