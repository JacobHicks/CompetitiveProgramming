// Date: 1 June 2019; Sophomore-Junior Summer
// Type: Problem Set Codeforces Type A
// Got AC: Yes
// Number of wrong submissions : 0
// Link: http://codeforces.com/contest/122/problem/A

import java.util.Scanner;

public class LuckyDiv {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int n = in.nextInt();
	    int tmpn = n;
	    boolean res = true;
	    while(tmpn != 0) {
	        int dig = tmpn % 10;
	        tmpn /= 10;
	        if (dig != 4 && dig != 7) {
	            res = false;
	            break;
            }
        }

	    if(!res) {
	        l:
	        for(int i = 1; i <= n; i++) {
	            tmpn = i;
                while(tmpn != 0) {
                    int dig = tmpn % 10;
                    tmpn /= 10;
                    if (dig != 4 && dig != 7) {
                        continue l;
                    }
                }
                if(n % i == 0) {
                    res = true;
                    break;
                }
            }
        }

	    System.out.println(res ? "YES" : "NO");
    }
}
