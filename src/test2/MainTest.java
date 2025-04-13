package test2;

import org.junit.jupiter.api.Test;
import testing2.Main;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void formattaDataFull() {
        String risultato = Main.formattaDataFull();
        assertEquals("venerdì 1 marzo 2002 14:00:00 Ora standard dell’Europa centrale", risultato);
    }

    @Test
    void formattaDataMedium(){
        String risultato = Main.formattaDataMedium();
        assertEquals("1 mar 2002, 13:00:00", risultato);
    }

    @Test
    void formattaDataShort(){
        String risultato = Main.formattaDataShort();
        assertEquals("01/03/02, 13:00", risultato);
    }



}