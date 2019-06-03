// Date: 1 June 2019; Sophomore-Junior Summer
// Type: Problem Set Codeforces Type B
// Got AC: Yes
// Number of wrong submissions : 1
// Link: http://codeforces.com/contest/158/problem/B

import java.util.Scanner;
import java.util.regex.Matcher;

public class Taxi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ones = 0;
        int twos = 0;
        int threes = 0;
        int fours = 0;
        for(int i = 0; i < n; i++) {
            int d = in.nextInt();
            if(d == 4) fours++;
            else if(d == 3) threes++;
            else if(d == 2) twos++;
            else ones++;
        }
        int res = fours;
        int t = Math.min(ones, threes);
        res += t;
        ones -= t;
        threes -= t;
        twos += ones / 2;
        ones %= 2;
        res += twos/2;
        twos %= 2;
        if(twos == 1 && ones == 1) ones = 0;
        res += ones + twos + threes;
        System.out.println(res);
    }
}
