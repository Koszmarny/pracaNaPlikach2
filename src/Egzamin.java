import java.util.StringTokenizer;

public class Egzamin {

    public static String zaliczenie(String dane){
        StringBuilder wynik = new StringBuilder();

        StringTokenizer zal = new StringTokenizer(dane, " ");
        wynik.append(zal.nextElement());
        return wynik.toString();
    }
}
