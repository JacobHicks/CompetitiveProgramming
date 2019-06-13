// Date: 12 June 2019; Sophomore-Junior Summer
// Type: Problem Set Codeforces Type A
// Got AC: Yes
// Number of wrong submissions: im only counting 2
// Link: http://codeforces.com/problemset/problem/550/A
import java.util.Scanner;

public class TwoSubstrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println((r(new int[str.length()][2][2], str, 0, false, false)) ? "YES" : "NO");
    }

    static boolean r(int[][][] dp, String str, int i, boolean ab, boolean ba) {
        if(i >= str.length() - 1) return ab && ba;
        if(dp[i][ab ? 1 : 0][ba ? 1 : 0] != 0) return dp[i][ab ? 1 : 0][ba ? 1 : 0] == 1;
        boolean res = false;
        if(!ab && str.charAt(i) == 'A' && str.charAt(i + 1) == 'B') {
            res = r(dp, str, i + 2, true, ba);
        }
        else if(!ba && str.charAt(i) == 'B' && str.charAt(i + 1) == 'A') {
            res = r(dp, str, i + 2, ab, true);
        }
        if(!res) res = r(dp, str, i + 1, ab, ba);
        dp[i][ab ? 1 : 0][ba ? 1 : 0] = res ? 1 : -1;
        return res;
    }
}
