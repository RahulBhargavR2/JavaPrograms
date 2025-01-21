package rahul;

import java.util.Scanner;

public class BreakingRecords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        int max = arr[0], min = arr[0], a = 0, b = 0;
        for (int i : arr) {
            if (i > max) {
                max = i;
                a++;
            }
            if (i < min) {
                min = i;
                b++;
            }
            System.out.println(a + " " + b);

        }
        System.out.println(a + " " + b);

    }
}
