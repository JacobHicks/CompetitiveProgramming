// Date: 10 June 2019; Sophomore-Junior Summer
// Type: Problem Set Codeforces Type A
// Got AC: Yes
// Number of wrong submissions : 1
// Link: http://codeforces.com/problemset/problem/1/A
import java.util.Scanner;

public class TheatreSquare {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double n = in.nextInt();
        double m = in.nextInt();
        int a = in.nextInt();
        System.out.println((long)(Math.ceil(n / a) * Math.ceil(m / a)));
    }
}
