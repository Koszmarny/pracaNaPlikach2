import java.io.*;
import java.util.Scanner;

public class EgzaminFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("podaj nazwe pliku z danymi: ");
        String file = scan.next();
        System.out.println("podaj nazwe pliku do zapisu: ");
        String write = scan.next();

        try (BufferedReader buforOdczytu = new BufferedReader(new FileReader(file));
             PrintWriter buforZapisu = new PrintWriter(new BufferedWriter(new FileWriter(write)))) {
            while (buforOdczytu.ready()) {
                buforZapisu.append(Egzamin.zaliczenie(buforOdczytu.readLine()));
            }
        }catch (IOException e){

        }
    }
}
