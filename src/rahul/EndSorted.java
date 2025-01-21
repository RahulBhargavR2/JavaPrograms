package rahul;

import java.util.Scanner;

public class EndSorted {
    private int noOfPermutations(int[] arr){
        int len = arr.length, first = 0, second = 0;

        if(arr[0] == 1 && arr[len-1] == len) return 0;

        for (int i = 0; i < len; i++) {
            if (arr[i] == 1) first = i;
            else if (arr[i] == len) second = i;
        }

        int indexLen = len - 1,lastInd = indexLen - second;
        //indexLen to get 0 based indexing
        //last index to compute distance btw the final index num and its destination
        if (first > second) return first + lastInd - 1;
        //if first index no comes after second last index no we need distance btw 0 and first index length +
        // distance of last index element from back of array - 1 permutations
        // or else just their distance sum no of permutations required
        return first + lastInd;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        while (n-->0){
            int size = scan.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) arr[i] = scan.nextInt();
            System.out.println(new EndSorted().noOfPermutations(arr));
        }
    }
}
