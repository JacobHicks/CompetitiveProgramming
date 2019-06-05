// Date: 5 June 2019; Sophomore-Junior Summer
// Type: Problem Set Codeforces Type B
// Got AC: No
// Number of wrong submissions : 2+
// Link: http://codeforces.com/problemset/problem/1156/B
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UglyPairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numDataSets = in.nextInt();
        in.nextLine();
        for(int dataSet = 0; dataSet < numDataSets; dataSet++) {
            String s = in.nextLine();
            ArrayList<Character> ls = new ArrayList<>();
            for(char c : s.toCharArray()) ls.add(c);
            System.out.println(dfs(ls, "", s.length()));

        }
    }

    public static String dfs(List<Character> choices, String current, int len) {
        if(current.length() == len) {
            return current;
        }
        String res = "No answer";
        for(int i = 0; i < choices.size(); i++) {
            char c = choices.get(i);
            if(current.length() == 0 || Math.abs(current.charAt(current.length() - 1) - c) != 1) {
                choices.remove(i);
                String n = dfs(choices, current + c, len);
                choices.add(i, c);
                if (!n.equals(res)) {
                    res = n;
                    break;
                }
            }
        }
        return res;
    }
}
