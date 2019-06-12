// Date: 12 June 2019; Sophomore-Junior Summer
// Type: Problem Set Codeforces Type C (oddly easy though)
// Got AC: Yes
// Number of wrong submissions: 1
// Link: http://codeforces.com/problemset/problem/4/C

import java.util.HashMap;
import java.util.Scanner;

public class RegistrationSystem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ds = in.nextInt();
        in.nextLine();
        HashMap<String, Integer> names = new HashMap<>();
        while(ds-- > 0) {
            String name = in.nextLine();
            if(names.keySet().contains(name)) {
                System.out.println(name + names.get(name));
                names.put(name, names.get(name) + 1);
            }
            else {
                names.put(name, 1);
                System.out.println("OK");
            }
        }
    }
}
