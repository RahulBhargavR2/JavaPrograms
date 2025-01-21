package rahul;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings("unused")
public class BinarySearch {
    private static int binary(int[] arr, int key, int beg, int end) {
        if (beg > end) return -1;
        int mid = (beg + end) / 2;
        if (arr[mid] == key) return mid + 1;
        if (key > arr[mid]) return binary(arr, key, mid + 1, end);
        return binary(arr, key, beg, mid - 1);
    }

    private int binary(int[] arr, int key) {
        return binary(arr, key, 0, arr.length - 1);
    }

    public static void binarySearch(@NotNull int[] arr, int ele) {
        int n = arr.length;
        int beg = 0, end = n - 1, pos = -1;
        while (end >= beg) {
            int mid = (beg + end) / 2;
            if (mid == ele) {
                pos = mid;
                break;
            } else if (ele < mid) end = mid - 1;
            else beg = mid + 1;
        }
        if (pos == -1) System.out.println("The element is not found  ");
        else System.out.println("Element is found at position " + pos);
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the search element");
        int ele = sc.nextInt();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(new BinarySearch().binary(arr, ele));

    }
}

