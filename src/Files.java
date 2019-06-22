import java.io.File;
import java.util.Scanner;

public class Files {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("podaj nazwe katalogu: ");
        String kat = scan.next();
        File katalog = new File(kat);
        if (katalog.exists() && katalog.isDirectory()) {
            File[] list = katalog.listFiles();
            for (File element : list) {
                System.out.println(drwx(element));
            }
        }
    }

    public static StringBuilder drwx(File element) {
        StringBuilder result = new StringBuilder();
        result.append(element.isDirectory() ? "d" : "-");
        result.append(element.canRead() ? "r" : "-");
        result.append(element.canWrite() ? "w" : "-");
        result.append(element.canExecute() ? "x" : "-");
        result.append(" "+element.getName());
        return result;
    }
}