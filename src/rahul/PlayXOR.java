package rahul;

import java.util.Scanner;

public class PlayXOR {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-->0){
            int size = scan.nextInt();
            int sub = scan.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = scan.nextInt();
            }
            boolean cond = false;
            int bit = 0;
            int noOfSub = size-(sub-1);
            //to find the no of sub arrays possible with given size of array and size of subarray
            // let size of array be arrLen and size of subarray be subLen
            //then we have no of sub-array's possible is given by arrLen-(subLen-1)
            //loop to repeat only no of times equal to no sub-array's possible
            for (int i = 0; i < noOfSub; i++) {
                for (int j = 0; j < sub; j++) {
                    if (arr[j+i] % 2 != 0) {
                        cond = true;
                        break;
                    }
                    cond = false;
                }
                    if (cond) bit++;
            }
            System.out.println(bit);
        }
    }
}