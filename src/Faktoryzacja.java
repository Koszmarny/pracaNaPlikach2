import java.util.Random;
import java.util.Scanner;

public class Faktoryzacja {

    public static double Euklides(double x, double y){
        while (x != y){
            if (x > y)
                x -= y;
            else
                y -= x;
        }
        return x;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("e: ");
        double e = scan.nextInt();
        System.out.println("d: ");
        double d = scan.nextInt();
        System.out.println("n: ");
        double n = scan.nextInt();
        Random rand = new Random();
        double t = e * d - 1;
        double s = 0;
        while (t % 2 == 0) {
            t /= 2;
            s++;
        }
        double a = 0;
        do {
            a = rand.nextInt(100);
        } while (Euklides(a, n) != 1);
        double c = a;
        a = Math.pow(a, t) % n;
        while (a != 1) {
            c = a;
            a = Math.pow(c, 2) % n;
            if ((c != 1 % n) && (a == 1 % n)) {
                break;
            }
        }

        double p = Euklides(c - 1, n);
        double q = Euklides(c + 1, n);
        System.out.println("p="+p+"q="+q);
    }
}

