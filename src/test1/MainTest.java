package test1;

import org.junit.jupiter.api.Test;
import testing1.Main;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

   // private Main testing = new Main();
    // non è necessario perché formattaData() è public static e può essere chiamato direttamente

    @Test
    void formattaData() {
        //Main.formattaData() ritorna una stringa
        String risultato = Main.formattaData();

        //verifico che risultato coincida con la stringa che mi aspetto
        assertEquals("08/02/2024 13:00:00",risultato);
        //oppure
        //assertArrayEquals(risultato.toCharArray(), "08/02/2024 13:00:00".toCharArray());

    }
}