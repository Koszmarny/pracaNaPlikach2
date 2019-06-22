import java.util.Arrays;
public enum Months {
    STYCZEŃ, LUTY, MARZEC, KWIECIEŃ, MAJ,
    CZERWIEC {
        public String toString() {
            return "sesja";
        }
    }, LIPIEC,
    SIERPIEŃ, WRZESIEŃ, PAŹDZIERNIK, LISTOPAD, GRUDZIEN;

    interface Function{}
    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
    public static void main(String[] args) {
        System.out.println(Months.CZERWIEC);
        System.out.println(Arrays.toString(Months.values()));
    }

}




