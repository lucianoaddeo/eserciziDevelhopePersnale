import java.time.DayOfWeek;
import java.time.Month;
import java.time.OffsetDateTime;

public class Main {
    public static void main(String[] args) {
        //creazione data
        OffsetDateTime data = creaData();
        int anno = anno(data);
        Month mese = mese(data);
        int giorno = giorno(data);
        DayOfWeek giornoSettimana = giornoSettimana(data);

        //stampe
        System.out.println(data);
        System.out.println(anno);
        System.out.println(mese);
        System.out.println(giorno);
        System.out.println(giornoSettimana);
    }

    public static OffsetDateTime creaData(){
        String dataStringa = "2023-03-01T13:00:00Z";
        return OffsetDateTime.parse(dataStringa);
    }

    public static int anno(OffsetDateTime dataOffset){
        return dataOffset.getYear();
    }

    public static Month mese(OffsetDateTime dataOffset){
        return dataOffset.getMonth();
    }
    public static int giorno(OffsetDateTime dataOffset){
        return dataOffset.getDayOfMonth();
    }
    public static DayOfWeek giornoSettimana(OffsetDateTime dataOffset){
        return dataOffset.getDayOfWeek();
    }
}

/*
Crea un oggetto data da questa stringa 2023-03-01T13:00:00Z
Ottieni l'anno
Ottieni il mese
Ottieni il giorno
Ottieni il giorno della settimana
Stampa i risultati sulla console -Crea dei test per questo esercizio


 */