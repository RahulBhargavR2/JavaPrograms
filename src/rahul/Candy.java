package rahul;

import java.util.Scanner;

public class Candy {
    private static int max(int[] arr) {
        //use 2 pointers, one to track a max value another to compare the array values
        int recentMax = arr[0], count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < recentMax) count++;
            else recentMax = arr[i];
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            int size = scan.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = scan.nextInt();

            System.out.println(max(arr));
        }
    }
}
