// Date: 12 June 2019; Sophomore-Junior Summer
// Type: Problem Set Codeforces Type C
// Got AC: Yes
// Number of wrong submissions: 7 (pranked hard)
// Link: http://codeforces.com/problemset/problem/489/C

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class GLaSD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int sum = in.nextInt();
        String[] res = new String[2];
        res[0] = "-1";
        res[1] = "-1";
        if(length == 1 && sum == 0) {
            res[0] = "0";
            res[1] = "0";
        }
        else {
            int[][] dp = new int[sum + 1][length + 1];
            r(dp, res, sum, length, "");
            if (!res[0].equals("-1") && res[1].equals("-1")) {
                r1(dp, res, sum, length, "");
            }
        }
        System.out.println(res[0] + " " + res[1]);
    }

    static boolean r(int[][] dp, String[] res, int sum, int length, String num) {
        if(sum == 0 && length == 0) {
            if(res[0].equals("-1")) {
                res[0] = num;
                /*if (num.charAt(num.length() - 1) != '0') {
                    res[1] = "";
                    for (Character c : num.toCharArray()) {
                        res[1] = c + res[1];
                    }
                }*/
                return true;
            }
        }
        if(sum < 0 || length < 0) {
            return false;
        }
        if(dp[sum][length] == -1) return false;
        int isValid = -1;
        for(int i = 0; i <= 9; i++) {
            if(i == 0 && num.equals("")) continue;
            if(r(dp, res, sum - i, length - 1, num + i)) {
                isValid = 1;
                break;
            }
        }
        dp[sum][length] = isValid;
        return isValid == 1;
    }

    static boolean r1(int[][] dp, String[] res, int sum, int length, String num) {
        if(sum == 0 && length == 0) {
            res[1] = num;
            return true;
        }
        if(sum < 0 || length < 0) {
            return false;
        }
        if(dp[sum][length] == -1) return false;
        int isValid = -1;
        for(int i = 9; i >= 0; i--) {
            if(i == 0 && num.equals("")) continue;
            if(r1(dp, res, sum - i, length - 1, num + i)) {
                isValid = 1;
                break;
            }
        }
        dp[sum][length] = isValid;
        return isValid == 1;
    }
}
