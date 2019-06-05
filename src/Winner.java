// Date: 5 June 2019; Sophomore-Junior Summer
// Type: Problem Set Codeforces Type A
// Got AC: Yes
// Number of wrong submissions : 5
// Link: http://codeforces.com/problemset/problem/2/A

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Winner {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ds = in.nextInt();
        in.nextLine();
        HashMap<String, int[]> timerec = new HashMap<>();
        for(int i = 0; i < ds; i++) {
            String name = in.next();
            int score = in.nextInt();

            if(!timerec.containsKey(name)) {
                int[] newint = new int[ds];
                Arrays.fill(newint, Integer.MIN_VALUE);
                newint[0] = 0;
                timerec.put(name, newint);
            }
            int x;
            for(x = i - 1; x >= 0 && timerec.get(name)[x] == Integer.MIN_VALUE; x--);
            timerec.get(name)[i] = score + timerec.get(name)[Math.max(0,x)];
        }
        int max = Integer.MIN_VALUE;
        String winner = "";
        for(String name : timerec.keySet()) {
            int x;
            for(x = ds - 1; x >= 0 && timerec.get(name)[x] == Integer.MIN_VALUE; x--);
            if(timerec.get(name)[x] > max) {
                max = timerec.get(name)[x];
                winner = name;
            }
            else if(timerec.get(name)[x] == max) {
                int challengerindex = Integer.MAX_VALUE;
                for(int i = 0; i < ds; i++) {
                    if(timerec.get(name)[i] >= max) {
                        challengerindex = i;
                        break;
                    }
                }
                int maxindex = Integer.MAX_VALUE;
                for(int i = 0; i < ds; i++) {
                    if(timerec.get(winner)[i] >= max) {
                        maxindex = i;
                        break;
                    }
                }

                if(challengerindex < maxindex) {
                    winner = name;
                }
            }
        }
        System.out.println(winner);
    }
}
