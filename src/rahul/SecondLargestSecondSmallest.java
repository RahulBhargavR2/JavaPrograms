package rahul;

import java.util.Arrays;
import java.util.Scanner;

public class SecondLargestSecondSmallest {
    private static int[] second(int[] arr){
        int max1=arr[0], max2=Integer.MIN_VALUE, min1=arr[0], min2 = Integer.MAX_VALUE;
        for(int i=1;i< arr.length;i++){
            if(arr[i]>max1){
                max2 = max1;
                max1 = arr[i];
            }
            else if( max2<arr[i])
                max2 = arr[i];

            if(arr[i]<min1){
                min2 = min1;
                min1 = arr[i];
            }
            else if( min2>arr[i])
                min2 = arr[i];
        }

        return new int[]{min2,max2};
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(second(arr)));
    }
}
