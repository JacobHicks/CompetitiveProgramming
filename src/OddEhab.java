// Date: 3 June 2019; Sophomore-Junior Summer
// Type: In-Contest Codeforces Type B
// Got AC: Yes
// Time taken: 1:34 (way too slow!)
// Ideal Time Taken: < 0:05
// Number of wrong submissions: 4
// Link: http://codeforces.com/contest/1174/problem/B

import java.util.Arrays;
import java.util.Scanner;

public class OddEhab {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        boolean hasOdd = false;
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
            if(array[i] % 2 == 1) hasOdd = true;
        }
        if(hasOdd) Arrays.sort(array);
        //quickSort(array, 0, n-1);
        for (int i = 0; i < n; i++) {
            System.out.print(array[i]);
            if(i != n - 1) {
                System.out.print(" ");
            }
            else System.out.println();
        }
    }



    /*

    public static int partition(int[] arr, int left, int right) {
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];
        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j && (arr[left] + arr[right]) % 2 == 1) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
            else if (i <= j) {
                i++;
                j--;
            }
        }
        return i;
    }

    public static void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1)
            quickSort(arr, left, index - 1);
        if (index < right)
            quickSort(arr, index, right);
    }
    */
}
//I thought it was way harderr grr//
