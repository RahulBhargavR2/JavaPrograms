package codingChallenge.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySumK {
    public int lenOfLongestSubarr(int[] arr, int required) {
        // prefixSum,index
        // using concept of prefix sum
        //when prefix sum is calculated we remove the number that is we require
        //and check if there is any prefix sum exists after removal
        //if exist that means there is a sub-array that contains the sum that we need
        //so we calculate the length of wanted sub-array
        //maps provide best service for these kind of problems as the retrieval time is O(1)
        Map<Long, Integer> prefixSum = new HashMap<>();
        long sum = 0L;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == required) {
                // adding i+1 because we need to consider the length
                //whereas i is the index starting from zero

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
}
