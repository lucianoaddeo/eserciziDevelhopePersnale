import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {

        public static void main(String[] args) {
            User u1 = new User();
            u1.stampaDettagli();

            User u2 = new User();
            u2.setEtà(22);
            u2.setNome("Marco");
            u2.stampaDettagli();
        }

}
/*
Crea una classe User che abbia i parametri privati nome ed età e i getter e setter
All'interno di User ci sarà anche una funzione che stampi a video le informazioni di età e il nome.
Creare 2 oggetti User di cui creerà un'istanza.
Del primo si stamperanno le informazioni di default,
 del secondo si cambieranno le informazioni e poi si stamperanno a video
 */