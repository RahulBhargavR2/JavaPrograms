package rahul;

import java.util.HashMap;
import java.util.Map;

public class LargestOutlier {

    private static boolean isPresent(int[] arr, int l, int r, int required) {
        Map<Long, Integer> prefixSum = new HashMap<>();
        long sum = 0L;
        int maxLength = 0;
        for (int i = l; i < r; i++) {
            sum += arr[i];
            if (sum == required) {

                return true;

            }

            long remaining = sum - required;

            if (prefixSum.containsKey(remaining)) {
                int length = i - prefixSum.get(remaining);
                maxLength = Math.max(maxLength, length);
            }

            if (!prefixSum.containsKey(sum)) {
                prefixSum.put(sum, i);
            }
        }
        return false;
    }

    public static int getLargestOutlier(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int max = Integer.MIN_VALUE, count = 0, ind = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                    ind = j;
                }
            }
            for (int j = 0; j < nums.length; j++)
                if (nums[j] == max) count++;
            // if(count>1)
            //     continue;
            if (!isPresent(nums, 0, ind, max) || !isPresent(nums, ind + 1, nums.length, max))
                return max;

        }
        return -1;

    }

    public static void main(String[] args) {
        int[]arr = {-2,-1,-3,-6,4};
        System.out.println(getLargestOutlier(arr));
    }

}
