import java.util.Scanner;

public class ChungaChanga {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long s = in.nextLong();
        long m = in.nextLong();
        long c = in.nextLong();
        long total = s/c + m/c;
        long toGive = 0;
        long ds = s % c;
        long dm = m % c;
        if(ds + dm >= c) {
            total++;
            toGive = Math.min(c - dm, c - ds);
        }
        System.out.println(total + " " + toGive);
    }
}
