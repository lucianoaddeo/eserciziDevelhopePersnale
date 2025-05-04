import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void creaData() {
        String dataStringa = "2023-03-01T13:00:00Z";
        ZonedDateTime data = ZonedDateTime.parse(dataStringa);
        assertEquals(data,Main.creaData());
    }

    @Test
    void dataModificata() {
        String dataStringa = "2023-03-01T13:00:00Z";
        ZonedDateTime data = ZonedDateTime.parse(dataStringa);
        ZonedDateTime risultato = data.plusYears(1).minusMonths(1).plusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                .withLocale(Locale.ITALY);
        assertEquals(formatter.format(risultato),Main.dataModificata(data));
    }
}