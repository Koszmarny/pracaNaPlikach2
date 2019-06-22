import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TestOsoba {
    public static void main(String[] args) {


        try (BufferedReader plik = new BufferedReader(new FileReader("./src/DaneOsobowe.txt.txt"))) {
            Scanner scan = new Scanner(plik);
            ArrayList<Osoba> lista = new ArrayList<Osoba>();
            while (plik.ready()) {
                String linia=plik.readLine();
                String[] dane = linia.split(" ");
                Osoba osoba = new Osoba(dane[0], dane[1], dane[2].equalsIgnoreCase("K"));
                lista.add(osoba);
            }
            lista.sort(((o1, o2) -> o1.getNazwisko().compareTo(o2.getNazwisko())));
            for (Osoba element : lista){
                System.out.println(element);
            }

        } catch (FileNotFoundException F) {
            System.out.println("hhh");
        } catch (IOException e) {
            System.out.println("fff");
        }

    }


}
