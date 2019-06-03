import java.util.Arrays;
import java.util.Scanner;

public class Ehab {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt() * 2;
        int[] array = new int[num];
        int sum = 0;
        for(int i = 0; i < num; i++) {
            array[i] = in.nextInt();
            sum += array[i];
        }
        Arrays.sort(array);
        int n1 = 0;
        for(int i = 0; i < array.length / 2; i++) {
            n1 += array[i];
        }
        if(sum - n1 != n1) {
            for (int i = 0; i < num; i++) {
                System.out.print(array[i]);
                if(i != num - 1) {
                    System.out.print(" ");
                }
                else System.out.println();
            }
        }
        else {
            System.out.println(-1);
        }
    }
}
