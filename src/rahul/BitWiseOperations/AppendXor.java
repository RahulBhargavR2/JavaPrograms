package rahul.BitWiseOperations;

import java.util.Scanner;

public class AppendXor {
    static Scanner scan = new Scanner(System.in);

    private static long append(int noOfElements, long target) {
        long[] arr = new long[noOfElements];
        long orOfArray = 0;
        for(int i=0;i<noOfElements;i++) {
            arr[i] = scan.nextLong();
            orOfArray |= arr[i];
        }
        long diff = orOfArray ^ target;
        return (orOfArray | diff) == target? diff: -1;
    }

    public static void main(String[] args) {
        int n = scan.nextInt();
        while (n-->0){
            int size = scan.nextInt();
            long tar = scan.nextLong();
            System.out.println(append(size,tar));
        }
    }
}