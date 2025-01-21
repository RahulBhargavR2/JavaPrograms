package rahul;

import java.util.*;

public class NextPermutation {
    private static void reverse(int[] arr) {
       reverse(arr,0,arr.length-1);
    }
    private static void reverse(int[] arr, int start,int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    private static void nextPermutation(int[] arr) {
        int breakPoint = -1;
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) {
                breakPoint = i - 1;
                break;
            }
        }
        if (breakPoint == -1) {
            reverse(arr);
            return;
        }
        for (int i = arr.length - 1; i > breakPoint; i--) {
            if (arr[breakPoint] < arr[i]) {
                int temp = arr[breakPoint];
                arr[breakPoint] = arr[i];
                arr[i] = temp;
                break;
            }
        }
        reverse(arr, breakPoint + 1, arr.length-1);
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 7, 5, 0};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }
}
