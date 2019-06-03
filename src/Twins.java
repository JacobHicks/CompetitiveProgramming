// Date: 1 June 2019; Sophomore-Junior Summer
// Type: Problem Set Codeforces Type A
// Got AC: Yes
// Number of wrong submissions : 2
// Link: http://codeforces.com/contest/160/problem/A

import java.util.Arrays;
import java.util.Scanner;

public class Twins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] coins = new int[num];
        for(int i = 0; i < num; i++) {
            coins[i] = in.nextInt();
        }
        Arrays.sort(coins);
        int sum = Arrays.stream(coins).sum();
        int curr = 0;
        int res = 0;
        for(int i = coins.length - 1; i >= 0; i--) {
            res++;
            curr += coins[i];
            if(curr > sum - curr) break;
        }
        System.out.println(res);
    }
}
