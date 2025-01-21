 package rahul;

import java.util.Scanner;

public class EvenSumSubArray {
    private static int max=0,sum=-1;
    private static void subArrays(int[] arr, int start, int end) {

        if (end == arr.length)
            return;

        if (start > end)
            subArrays(arr, 0, end + 1);

        else {
            for (int i = start,sum=0; i <= end; i++){
                sum += arr[i];
            }
            if (sum%2==0) max = Math.max(max,(end-start+1));
            subArrays(arr, start + 1, end);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-->0){
            int size = scan.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = scan.nextInt();
            }
            subArrays(arr,0,0);
            System.out.println(max);

        }
    }
}
