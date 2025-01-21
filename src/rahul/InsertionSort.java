package rahul;

import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Enter the size of list");
        int n = scan.nextInt();
        System.out.println("Enter the elements into list");
        for (int i = 0; i < n; i++)
            arr.add(scan.nextInt());
        int e = arr.get(n - 1);//gets the last element of array
        for (int i = arr.size() - 2; i >= 0; i--) {
            if (e < arr.get(i)) {//if previous value of element is higher copy it and pate it to last place
                arr.set(i + 1, arr.get(i));
                System.out.println(arr);
                if (i == 0) {
                    arr.set(0, e);
                    System.out.println(arr);
                }

            }
            if (e > arr.get(i)) {
                arr.set(i + 1, e);
                System.out.println(arr);
                break;
            }
        }

    }
}
