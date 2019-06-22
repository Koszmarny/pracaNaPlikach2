import java.util.Comparator;

public class Osoba implements Comparable<Osoba>, Comparator<Osoba> {

    protected String Imie;
    protected String Nazwisko;
    protected boolean czyKobieta;

    public Osoba(String imie,
                 String nazwisko, boolean czyKobieta) {
        this.Imie = imie;
        this.Nazwisko = nazwisko;
        this.czyKobieta = czyKobieta;
    }

    public String getImie() {
        return Imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public boolean getPlec() {
        return czyKobieta;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    @Override
    public int compareTo(Osoba o) {
        return getNazwisko().compareTo(o.getNazwisko());
    }

    @Override
    public int compare(Osoba o1, Osoba o2) {
        return o1.compareTo(o2);
    }

    public boolean equals(Osoba os) {
        return compareTo(os) == 0;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "Imie='" + Imie + '\'' +
                ", Nazwisko='" + Nazwisko + '\'' +
                ", czyKobieta=" + czyKobieta +
                '}';
    }
}
