// Date: 12 June 2019; Sophomore-Junior Summer
// Type: Problem Set Codeforces Type B
// Got AC: Yes
// Number of wrong submissions: 1
// Link: http://codeforces.com/problemset/problem/520/B
import java.util.Scanner;

public class TwoButtons {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int dest = in.nextInt();
        System.out.println(r(new int[Math.max(dest*2+1, num + 1)], num, dest));
    }
    static int r(int[] dp, int num, int dest) {
        if(num >= dp.length || num <= 0)
            return dp.length + 1;
        if(dp[num] != 0) return dp[num];
        if(num == dest) return 0;
        dp[num] = dp.length + 1;
        return dp[num] = Math.min(r(dp, num * 2, dest) + 1, r(dp, num - 1, dest) + 1);
    }
}
