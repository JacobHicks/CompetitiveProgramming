// Date: 10 June 2019; Sophomore-Junior Summer
// Type: Problem Set Codeforces Type A
// Got AC: Yes (may have looked at the test data after a while...)
// Number of wrong submissions: 7
// Link: http://codeforces.com/problemset/problem/455/A

import java.util.Scanner;

public class Boredom {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] A = new long[100001];
        for(int i = 0; i < n; i++) {
            int a = in.nextInt();
            A[a]++;
        }
        long[] res = new long[100001];
        res[1] = A[1];
        for(int i = 2; i < res.length; i++) {
            res[i] = Math.max(res[i-1], res[i-2] + A[i] * i);
        }
        System.out.println(res[100000]);
    }
}
