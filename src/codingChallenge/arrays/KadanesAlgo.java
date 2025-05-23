package codingChallenge.arrays;
//Given an integer array nums, find the with the largest sum, and return its sum.
public class KadanesAlgo {
    public int maxSubArray(int[] nums) {
        int sum = 0, maxSum = nums[0];
        for (int num : nums) {
            sum += num;
            maxSum = Math.max(sum, maxSum);
            if (sum < 0)
                sum = 0;
        }
        return maxSum;

    }
}
