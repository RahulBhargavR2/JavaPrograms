package codingChallenge.arrays;

public class MaxScoreFromSubArrayMins {
/*   Given an array arr[], with 0-based indexing, select any two indexes, i and j such that i < j.
     From the subarray arr[i...j], select the smallest and second-smallest numbers and add them,
     you will get the score for that subarray.
     Return the maximum possible score across all the sub-arrays of array arr[].
 */

    public int pairWithMaxSum(int[] arr) {
        // Your code goes here
        int sum = 0,max=0;
        for(int i=0;i<arr.length-1;i++){
            sum = arr[i]+arr[i+1];
            max= Math.max(sum, max);
        }
        return max;
    }
}
