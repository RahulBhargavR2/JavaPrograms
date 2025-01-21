package rahul;

import java.util.Scanner;

public class SubArrayMaxSumFixed {

    private int sum(int[] arr, int size){
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }
        int max = sum;
        for (int i = size ; i < arr.length  ; i++) {
            sum += arr[i] - arr[i-size];
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        SubArrayMaxSumFixed s = new SubArrayMaxSumFixed();
        System.out.println("Enter the array size");
        int n = scan.nextInt();
        System.out.println("Enter the size of sub-array");
        int k = scan.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements into array");
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.println(s.sum(arr,k));
    }
}
