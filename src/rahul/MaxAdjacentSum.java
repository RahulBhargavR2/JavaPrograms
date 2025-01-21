package rahul;

import java.util.Scanner;

public class MaxAdjacentSum {
    private static int maxSum(int[] arr, int sum) {
        int len = arr.length;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return (2 * sum) - (arr[len - 1] + arr[len - 2]);
    }
//find the sum of given elements as in an adjacent sum consists of all elements atleast once
//the remaining elements of adjacent sum consists of n-2 elements
//so choose n-2 larger elements or multiply the sum by 2 and subtract it form the least 2 elements
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            int size = scan.nextInt();
            int[] arr = new int[size];
            int sum = 0;
            for (int i = 0; i < size; i++) {
                arr[i] = scan.nextInt();
                sum += arr[i];
            }
            System.out.println(maxSum(arr, sum));
        }
    }
}
