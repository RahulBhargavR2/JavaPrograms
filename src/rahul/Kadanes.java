package rahul;

import java.util.*;

public class Kadanes {
    private static int[] check(int[] arr) {
        int sum = 0, max = 0;
        int n = arr.length, j = 0, k = 0;
        for (int i = 0; i < n; i++) {

            sum += arr[i];
//            k++;

            if (sum > max) {
                max = sum;
                k = i;
            }
            if (sum < 0) {
                sum = 0;
                j = k = i + 1;
            }
        }
        // returning the result.
        System.out.println(max);
        return new int[]{j, k};
    }

    public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            int n = scan.nextInt();
            while (n-->0){
                int size = scan.nextInt();
                int[] arr = new int[size];
                for (int i=0;i<size;i++)
                    arr[i] = scan.nextInt();
                System.out.println(Arrays.toString(check(arr)));
            }

    }
}
