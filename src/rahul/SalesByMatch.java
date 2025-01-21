package rahul;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SalesByMatch {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> ar = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        System.out.println("Enter the size of list");
        int n = scan.nextInt();
        for (int i = 0; i < n; i++)
            arr.add(scan.nextInt());
        int m = Collections.max(arr);
        if (m > n) {
            for (int i = 0; i <= m; i++)
                ar.add(0);
        } else {
            for (int i = 0; i <= n; i++)
                ar.add(0);
        }

        for (int i : arr) {
            ar.set(i, ar.get(i) + 1);
        }
        for (Integer integer : ar) {
            if (integer != 0)
                a.add(integer);
        }
        int remi = 0;
        for (int s : a) {
            remi += s / 2;
        }
        System.out.println(remi);
    }
}

