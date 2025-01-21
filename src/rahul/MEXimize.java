package rahul;

import java.util.Arrays;
import java.util.Scanner;
/**<a href="https://www.codechef.com/problems/MEXARR">Meximze array</a>*/
public class MEXimize {

    private static long check(int[] arr, int size) {
        long count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < size; i++)
            count += Math.abs(arr[i] - i);
        return count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            int size = scan.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) arr[i] = scan.nextInt();
            System.out.println(check(arr, size));

        }

    }
}
