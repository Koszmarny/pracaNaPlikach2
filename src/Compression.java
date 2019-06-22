import java.io.*;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class Compression {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("podaj nazwe pliku do odczytu: ");
        String file = scan.next();
        try (BufferedOutputStream doKompresji = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(file)))) {

        } catch (IOException e) {

        }
        System.out.println("podaj nazwe pliku do zapisu: ");
        String file2 = scan.next();
        try (BufferedInputStream doDekompresji = new BufferedInputStream(
                new GZIPInputStream(
                        new FileInputStream(file2)))) {

        } catch (IOException e2) {

        }
    }
}
