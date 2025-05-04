import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;
class MainTest {

    @Test
    void creaData() {
        String dataStringa = "2023-03-01T13:00:00Z";
        OffsetDateTime data = OffsetDateTime.parse(dataStringa);
        assertEquals(data,Main.creaData());
    }

    @Test
    void anno() {
        String dataStringa = "2023-03-01T13:00:00Z";
        OffsetDateTime data = OffsetDateTime.parse(dataStringa);
        int anno = data.getYear();
        assertEquals(anno,Main.anno(data));
    }

    @Test
    void mese() {
        String dataStringa = "2023-03-01T13:00:00Z";
        OffsetDateTime data = OffsetDateTime.parse(dataStringa);
        Month mese = data.getMonth();
        assertEquals(mese,Main.mese(data));
    }

    @Test
    void giorno() {
        String dataStringa = "2023-03-01T13:00:00Z";
        OffsetDateTime data = OffsetDateTime.parse(dataStringa);
        int giorno = data.getDayOfMonth();
        assertEquals(giorno,Main.giorno(data));
    }

    @Test
    void giornoSettimana() {
        String dataStringa = "2023-03-01T13:00:00Z";
        OffsetDateTime data = OffsetDateTime.parse(dataStringa);
        DayOfWeek giorno = data.getDayOfWeek();
        assertEquals(giorno,Main.giornoSettimana(data));
    }
}
