package test3;

import org.junit.jupiter.api.Test;
import testing3.Main;

import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void formattaData() {
        String risultato = Main.formattaData();
        assertEquals("01 marzo 2023",risultato);
    }
}