import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

        public static void main(String[] args) {

//            ArrayList<Shape> listaForme = new ArrayList<>();
            for(Forma f : Forma.values()){
                ShapeFactory.creaForma(f).draw();
//                listaForme.add(ShapeFactory.creaForma(f));
            }
        }


       enum Forma{
            Rettangolo,
            Cerchio
        }

}
/*
Crea un'interfaccia Shape e un metodo draw, crea 2 o più classi che implementino Shape.
Cre una enum che abbia tutti i tipi di shape che hai creato ( cerchio, rettangolo etc etc)
Crea una factory class che abbia un metodo che ritorni la forma corretta (shape) in base all'enum in input.
Stampa a video il risultato della funzione draw di ogni shape creata
 */