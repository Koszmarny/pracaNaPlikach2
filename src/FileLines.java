import java.io.*;
import java.util.Scanner;

public class FileLines {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("podaj nazwe pliku: ");
        String file = scan.next();
        try (BufferedReader bufor = new BufferedReader(new FileReader(file))) {
            int nr = 1;
            while (bufor.ready()){
                System.out.println(nr + ": " + bufor.readLine());
                nr++;
            }
        } catch (FileNotFoundException f) {
            System.out.println("nie ma takiego pliku!");
        } catch (IOException e) {

        }
    }
}
