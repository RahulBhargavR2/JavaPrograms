package rahul;

import java.util.Random;

public class PrefixSum {
    static int[] prefix;

    private static int prefixSum(int left, int right) {
        return prefix[right] - prefix[left - 1];
    }

    private static void createPrefix(int[] arr) {
        prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
    }

    private static void printArray(int[] arr) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = random.nextInt(15);
        }
        createPrefix(arr);
        printArray(arr);
        printArray(prefix);
        System.out.println(prefixSum(1, 5));

    }
}
