import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class FirstBytes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("podaj nazwe pliku: ");
        String file = scan.next();
        try (BufferedInputStream bufor = new BufferedInputStream(new FileInputStream(file))) {
            byte[] b = new byte[4];
            bufor.read(b);
            System.out.println(Arrays.toString(b));
        } catch (IOException e) {

        }
    }
}
