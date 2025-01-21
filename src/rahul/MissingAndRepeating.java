package rahul;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MissingAndRepeating {
    private static int[] findTwoElement(int[] arr, int n) {
        int repeating, missing ;
        long sum = 0, sumSquare = 0, expectedSum, expectedSumSquare;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            sumSquare += (long) arr[i] * arr[i];
        }
        expectedSum = (long) n * (n + 1) / 2;
        expectedSumSquare = (long) n * (n + 1) * (2L * n + 1) / 6;

        long diffSum = expectedSum - sum;
        long diffSumSquare = expectedSumSquare - sumSquare;

        missing = (int) ((diffSum + diffSumSquare / diffSum) / 2L);
        repeating = (int) (missing - diffSum);

        return new int[]{repeating, missing};
    }


    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        while (n-->0){
//            int size = scan.nextInt();
//            int[] arr = new int[size];
//            System.out.println(Arrays.toString(findTwoElement(arr,size)));
//        }

        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(1,19);
        map.put(3,29);
        map.put(2,39);
        System.out.println(map.put(1,20));
    }
}
