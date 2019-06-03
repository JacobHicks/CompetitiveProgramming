// Date: 1 June 2019; Sophomore-Junior Summer
// Type: Problem Set Codeforces Type A
// Got AC: Yes
// Number of wrong submissions : 8 (Spam Era)
// Link: http://codeforces.com/contest/158/problem/A

import java.util.Scanner;

public class NextRound {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt()-1;
        int[] P = new int[n];
        int res = 0;
        for(int i = 0; i < n; i++) {
            P[i] = in.nextInt();
            if(i <= k && P[i] != 0) res++;
        }
        if(P[k] > 0) {
            for(int i = k + 1; i < P.length && P[i] == P[i-1]; i++) {
                res++;
            }
        }
        System.out.println(res);
    }
}
