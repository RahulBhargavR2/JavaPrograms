package rahul;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@SuppressWarnings("unused")
public class SubArraySum {
    //only for positive elements
    private static int shortestLength(int[] arr, int requiredSum) {
        int start = 0, end = 0, minLen = Integer.MAX_VALUE;
        long sum = 0L;
        while (end < arr.length) {
            sum += arr[end++];


            while (sum > requiredSum && start < end) {
                sum -= arr[start++];
            }
            if (sum == requiredSum)
                minLen = Math.min(minLen, end - start);
        }
        return minLen;
    }

    //only for positive elements
    private static int longestLength(int[] arr, int requiredSum) {
        int start = 0, end = 0, maxLen = 0;
        long sum = 0L;
        while (end < arr.length) {
            sum += arr[end++];

            while (sum > requiredSum && start < end) {
                sum -= arr[start++];
            }
            if (sum == requiredSum)
                maxLen = Math.max(maxLen, end - start);
        }
        return maxLen;
    }

    //works for both positive and negative elements
    private static int longestLengthHashed(int[] arr, int required) {
        // prefixSum,index
        // using concept of prefix sum
        //when prefix sum is calculated we remove the number that is we require
        //and check if there is any prefix sum exists after removal
        //if exist that means there is a sub-array that contains the sum that we need,
        //so we calculate the length of wanted sub-array
        //maps provide best service for these kind of problems as the retrieval time is O(1)
        Map<Long, Integer> prefixSum = new HashMap<>();
        long sum = 0L;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == required) {
                // adding i+1 because we need to consider the length
                //whereas it is the index starting from zero

                maxLength = Math.max(maxLength, i + 1);

            }

            long remaining = sum - required;

            if (prefixSum.containsKey(remaining)) {
                int length = i - prefixSum.get(remaining);
                maxLength = Math.max(maxLength, length);
            }
            //if prefix sum doesn't exist then add it to map
            //we should not add if prefix sum already exists as the array contains negative
            //numbers the prefix sum might repeat thus leading to considering the latest
            //index thus making it to choose sub-array other than the longest sub-array
            if (!prefixSum.containsKey(sum)) {
                prefixSum.put(sum, i);
            }
        }
        return maxLength;

    }


    //Maximum Score from Sub-array Minimums
    //https://www.geeksforgeeks.org/problems/max-sum-in-sub-arrays0824/0?category

    private static int pairWithMaxSum(int[] arr) {
        int sum = 0,maxSum = 0, fir,sec;
       for(int i=0;i<arr.length-1;i++){
           maxSum = arr[i]+arr[i+1]>maxSum?arr[i]+arr[i+1]:sum;
       }
        return maxSum;
    }


    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        while (n--> 0) {
//            int size = scan.nextInt();
//            int[] arr = new int[size];
//            for (int i = 0; i < size; i++)
//                arr[i] = scan.nextInt();
//            int sum = scan.nextInt();
//            System.out.println(longestLength(arr, sum));
//        }
        int[]arr = {5,4,3,1,6};
        System.out.println(pairWithMaxSum(arr));
    }
}