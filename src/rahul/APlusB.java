package rahul;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class APlusB {

    private static void solve(int[] a, int[] b, int n) {
        Arrays.sort(a);
        Arrays.sort(b);
        reverse(b);
        boolean flag = true;
        int ini = a[0] + b[0];
        for (int i = 1; i < n; i++) {
            if (a[i] + b[i] != ini) {
                flag = false;
                break;
            }
        }
        if (flag) {
            print(a);
            print(b);
        } else System.out.println("-1");
    }

    private static void reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    private static void print(int[] a) {
        for (int i : a) System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-- > 0) {
            int size = scan.nextInt();
            int[] a = new int[size];
            int[] b = new int[size];

            for (int i = 0; i < size; i++) a[i] = scan.nextInt();
            for (int i = 0; i < size; i++) b[i] = scan.nextInt();

            solve(a, b, size);
        }
    }
}