package rahul;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class BubbleSort   {
    public static void bubble(@NotNull int[] a) {

        int n = a.length;
        long start = System.nanoTime();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
//        long end = System.nanoTime();
//        System.out.println("Run time is " + (end - start));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of array ");
        int n = scan.nextInt();
        int[] a = new int[n];

        System.out.println("Enter the elements into array");
        for (int i = 0; i < n; i++) a[i] = scan.nextInt();

        bubble(a);

        System.out.println("Array after sort is ");
        for (int i = 0; i < n; i++) System.out.println(a[i]);

    }
}