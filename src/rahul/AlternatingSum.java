package rahul;

import java.util.Arrays;
import java.util.Scanner;

public class AlternatingSum {
    private static int check(int[] arr){
        Arrays.sort(arr);
        int sum=0;
        for(int i=(arr.length)/2;i<arr.length;i++) sum+=arr[i];
        for(int i=0;i<arr.length/2;i++) sum-=arr[i];
        return sum;
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while(n-->0){
            int size = scan.nextInt();
            int[]arr = new int[size];
            for(int i=0;i<size;i++) {
                arr[i] = scan.nextInt();
            }
            System.out.println(check(arr));
        }

    }
}
