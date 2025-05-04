import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        //calcola(1,3, );
        BigDecimal x = BigDecimal.valueOf(10);
        BigDecimal y = new BigDecimal("2");
        for(Operazione op : Operazione.values()){
            BigDecimal risultato = calcola(x,y,op);
            switch (op){
                case ADDIZIONE -> System.out.println(x +" + " + y + " = " + risultato);
                case SOTTRAZIONE -> System.out.println(x +" - " + y + " = " + risultato);
                case MOLTIPLICAZIONE -> System.out.println(x +" * " + y + " = " + risultato);
                case DIVISIONE -> System.out.println(x +" / " + y + " = " + risultato);
                case MIN -> System.out.println("Il minimo tra "+x+" e "+y +" è = "+risultato);
                case MAX -> System.out.println("Il massimo tra "+x+" e "+y +" è = "+risultato);
            }
        }

    }

    public static BigDecimal calcola(BigDecimal primo, BigDecimal secondo, Operazione op){
        return switch (op){
            case ADDIZIONE -> primo.add(secondo);
            case SOTTRAZIONE -> primo.subtract(secondo);
            case MOLTIPLICAZIONE -> primo.multiply(secondo);
            case DIVISIONE -> primo.divide(secondo);// ArithmeticException da gestire
            case MIN -> primo.min(secondo);
            case MAX -> primo.max(secondo);
        };
    }
}

/*
Scrivi un programma Java dove imposti 2 BigDecimal e 1 operazione aritmetica (Addizione, sottrazione, moltiplicazione e divisione, min e max) definita in un enum
Crei un metodo per calcolare l'operazione richiesta e e ritorni il risultato.
Il tipo di operazione, i due dati in input e il risultato dovranno essere stampati a schermo
 */