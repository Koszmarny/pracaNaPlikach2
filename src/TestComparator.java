import java.util.Comparator;

public class TestComparator {
    public static void main(String[] args) {
        Osoba o1 = new Osoba("Pawel","Byszewski",false);
        Osoba o2 = new Osoba("Krzysztow", "Boruta", false);

        int wynikPorownania;
        wynikPorownania = (new Comparator<Osoba>() {
            public int compare(Osoba o1, Osoba o2){
                return o1.getNazwisko().compareTo(o2.getNazwisko());
            }
        }).compare(o1,o2);
        int porownanie = o1.compareTo(o2);
    }
}
