package rahul;

import java.util.ArrayList;
import java.util.Scanner;

public class MinimumSumSubArray {
    private static int minSum(ArrayList<Integer> arr, int l, int r) {
        int minSum = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++)
                sum += arr.get(j);
            minSum = sum > 0 ? Math.min(minSum, sum) : minSum;
            for (int j = i; j < arr.size(); j++) {
                sum += arr.get(j) - arr.get(j - i);
                minSum = sum > 0 ? Math.min(minSum, sum) : minSum;
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;


    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            int size = scan.nextInt();
            ArrayList<Integer> arr = new ArrayList<>(size);
            for (int i = 0; i < size; i++)
                arr.add(scan.nextInt());
            int l = scan.nextInt();
            int r = scan.nextInt();
            System.out.println(minSum(arr, l, r));
        }
    }
}
