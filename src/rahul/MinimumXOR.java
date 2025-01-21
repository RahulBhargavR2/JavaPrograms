package rahul;

import java.util.Scanner;

public class MinimumXOR {
    private int removed(int[] arr){
        int xor  = 0,min = Integer.MAX_VALUE;
        for(int i:arr) xor ^= i;

        for (int i : arr) {
            int mini = xor ^ i;
            min = Math.min(min, mini);
        }
        return Math.min(min,xor);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        while (n-->0){
            int size = scan.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) arr[i] = scan.nextInt();
            System.out.println(new MinimumXOR().removed(arr));
        }
    }
}
