public class Faktoryzacja {

    public static double NWD(long numberA, long numberB) {
        while (numberA != numberB) {
            if (numberA > numberB) {
                numberA = numberA - numberB;
            } else {
                numberB = numberB - numberA;
            }
        }
        return numberA;
    }

    public static void main(String[] args) {
        double e = 2, d = 3, n = 5, s, t;
        double ed = e*d;
        ed-1=t* 2^s;
    }
}
