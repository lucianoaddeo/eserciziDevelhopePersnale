import java.time.DayOfWeek;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        //creazione data
        ZonedDateTime data = creaData();
        String dataModificata = dataModificata(data);

        //stampe
        System.out.println(data);
        System.out.println(dataModificata);

    }

    public static ZonedDateTime creaData(){
        String dataStringa = "2023-03-01T13:00:00Z";
        return ZonedDateTime.parse(dataStringa);
    }

    public static String dataModificata(ZonedDateTime dataOffset){
        ZonedDateTime risultato = dataOffset.plusYears(1).minusMonths(1).plusDays(7);
        // Formatter localizzato per l’Italia
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                .withLocale(Locale.ITALY);
        return formatter.format(risultato);
    }


}

/*
Crea un oggetto data da questa stringa 2023-03-01T13:00:00Z
aggiungi un anno
sottrai un mese
aggiungi 7 giorni
Stampa il risultato localizzata per l'Italia
Crea dei test per questo esercizio


 */