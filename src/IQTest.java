// Date: 10 June 2019; Sophomore-Junior Summer
// Type: Problem Set Codeforces Type A
// Got AC: Yes
// Number of wrong submissions : 0
// Link: http://codeforces.com/problemset/problem/25/A

import java.util.Scanner;

public class IQTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int e = -1;
        int o = -1;
        boolean isEven = true;
        for(int i = 0; i < n; i++) {
            int a = in.nextInt();
            if(a%2==0) {
                if(e != -1) {
                    isEven = false;
                }
                e = i + 1;
            }
            else {
                o = i + 1;
            }
        }
        System.out.println(isEven ? e : o);
    }
}
